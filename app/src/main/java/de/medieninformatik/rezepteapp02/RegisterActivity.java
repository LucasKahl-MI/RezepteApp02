package de.medieninformatik.rezepteapp02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * @author Lucas Kahl m27606
 * Semesterabgabe Prog4 Android SoSe 2021
 */

public class RegisterActivity extends AppCompatActivity {

    /**
     * Initialisierung der notwendigen Variablen für den Login-Bereich
     */
    private EditText email;
    private EditText passwort;
    private Button register;
    private ProgressDialog progressDialog;

    /**
     * Instanz für die Verbindung zur meiner Firebase Login-Datenbank
     */
    private FirebaseAuth auth;


    /**
     * Zuweisung der View-Elemente auf die entsprechenden Variablen
     * Datenbankverbindung zu Firebase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.et_email_login);
        passwort = findViewById(R.id.et_passwort_login);
        register = findViewById(R.id.bt_login_login);

        //Datenbankinstanz für Authentication
        auth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_passwort = passwort.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_passwort)) {
                    Toast.makeText(RegisterActivity.this, "leeres Pflichtfeld!", Toast.LENGTH_SHORT).show();
                } else if (txt_passwort.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Passwort zu kurz!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txt_email, txt_passwort);
                }
            }
        });
    }

    private void registerUser(String email, String passwort) {
        auth.createUserWithEmailAndPassword(email,passwort).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){


                    /**
                     * Anzeigen eines Ladebildschirmes als Nutzerfeedback
                     */
                    progressDialog = new ProgressDialog(RegisterActivity.this);
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.progress_view);
                    progressDialog.getWindow().setBackgroundDrawableResource(
                            android.R.color.transparent
                    );



                    Toast.makeText(RegisterActivity.this,"Registrierung erfolgreich!" , Toast.LENGTH_SHORT).show();

                    //Logging zu Informationszwecken, dass Registrierung erfolgreich war
                    Log.i("success_registration", "Registrierung erfolgreich");
                    openMainActivity();
                }else {
                    //Error-Logging
                    Log.e("error_registration","Registrierung konnte nicht erfolgreich durchgeführt werden! | Möglicherweise Netzwerkprobleme");
                    Toast.makeText(RegisterActivity.this,"Registrierung fehlgeschlagen!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        Log.i("success", "Erfolgreicher Übergang zur MainActivity nach erfolgreicher Registrierung.");
        startActivity(intent);
        finish();
    }
}