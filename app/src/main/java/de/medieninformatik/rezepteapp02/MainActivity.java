package de.medieninformatik.rezepteapp02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Kahl m27606
 * Semesterabgabe Prog4 Android SoSe 2021
 */

public class MainActivity extends AppCompatActivity {


    /**
     * Inizialisierung notwendiger Parameter
     */
    private Button logout;
    RecyclerView recyclerView;
    List<Rezepte> rezepteList = new ArrayList<>();

    /**
     * Hier werden aktuell die Rezepte eingetragen und anschließend mittels .add einer Array-List
     * hinzugefügt.
     * perspektivisch plane ich die Anbindung an eine Online-Datenbank, um Rezepte von dort aus
     * lesen zu können und um das Hinzufügen neuer Rezepte direkt aus der App zu ermöglichen
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Logout Butten wird angesprochen und über OnClickListener wird die Funktionalität implementiert
         * Nutzer erhält bei erfolgreichem Logout eine Toast-Nachricht
         */
        logout = findViewById(R.id.bt_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this,"Erfolgreich abgemeldet!" , Toast.LENGTH_SHORT).show();
                backToStart();
            }
        });

        /**
         * RecyclerView wird mittels Id im Layout angesprochen
         */
        recyclerView = findViewById(R.id.recyclesView_id2);

        /**
         * Methodenaufruf zum Holen der Daten
         */
        getDataFromDatabase();

        /**
         * RecyclerView wird dem Layout angefügt
         */
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, rezepteList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * Öffnet die Start Activity
     */
    private void backToStart() {

        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Holt die Liste aus der Datenbank nach Singleton-Entwurfsmuster
     */
    private void getDataFromDatabase() {
        rezepteList = RezepteDatenbank.getInstance().getList();
        Log.i("success", "Daten wurden erfolgreich aus der Singleton Datenklasse geladen");
    }
}