package de.medieninformatik.rezepteapp02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author Lucas Kahl m27606
 * Semesterabgabe Prog4 Android SoSe 2021
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {


    /**
     * Initialisierung notwendiger Variablen
     */
    List<Rezepte> empfangeneListe;
    Context context;

    /**
     * Konstruktor
     * @param ct
     * @param rezepteList
     */
    public RecyclerViewAdapter(Context ct, List<Rezepte> rezepteList) {
        this.context = ct;
        this.empfangeneListe = rezepteList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrecyclerviewrow, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.title.setText(empfangeneListe.get(position).getRecipeName());
        holder.beschreibung.setText(empfangeneListe.get(position).getRecipeSubtitle());
        holder.thumb.setImageResource(empfangeneListe.get(position).getThumbnail());

        /**
         * Wird ein Rezept geklickt, so werden hier alle notwendigen Daten geladen
         * und in einer neuen Activity dargestellt
         */
        holder.einzelkachel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RezepteActivity.class);

                intent.putExtra("RecipeName", empfangeneListe.get(position).getRecipeName());
                intent.putExtra("RecipeIngredients", empfangeneListe.get(position).getRecipeIngredients());
                intent.putExtra("RecipeSubtitle", "Zubereitung");
                intent.putExtra("Recipe", empfangeneListe.get(position).getRecipe());

                context.startActivity(intent);
            }
        });


    }

    /**
     * Bestimmt die Länge des Views
     * Abhängig von der Anzahl der in der Rezeptliste enthaltenen Rezepte
     * wächst demnach dynamisch mit wenn ein neues Rezept eingetragen wird
     * @return
     */
    @Override
    public int getItemCount() {
        return empfangeneListe.size();
    }


    /**
     * interne ViewHolder Classe
     * hält die gelesenen Daten bereit
     */
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView title, beschreibung;
        ImageView thumb;
        CardView  einzelkachel;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_rezTitel);
            beschreibung = itemView.findViewById(R.id.tv_rezBeschreibung);
            thumb = itemView.findViewById(R.id.iv_thumbnail);
            einzelkachel = itemView.findViewById(R.id.cardviewMainpage_id);
        }
    }
}
