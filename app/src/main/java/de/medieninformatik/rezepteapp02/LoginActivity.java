package de.medieninformatik.rezepteapp02;

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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    /**
     * @author Lucas Kahl m27606
     * Semesterabgabe Prog4 Android SoSe 2021
     */


    /**
     * Initialisierung der notwendigen Variablen für den Login-Bereich
     */
    private EditText email;
    private EditText passwort;
    private Button login;
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
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_email_login);
        passwort = findViewById(R.id.et_passwort_login);
        login = findViewById(R.id.bt_login_login);

        //Datenbankinstanz für Authentication
        auth = FirebaseAuth.getInstance();

        /**
         * Mail und Passwort werden gelesen und an die loginUser-Methode übergeben
         * Aktuell ist keine Evaluierung und Bestätigung der Mail implementiert, daher funktioniernen
         * auch ausgedachte Mails
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_passwort = passwort.getText().toString();

                if (TextUtils.isEmpty(txt_email)|| TextUtils.isEmpty(txt_passwort)){
                    Toast.makeText(LoginActivity.this, "Mail und/oder Passwort ist leer!", Toast.LENGTH_SHORT).show();
                }else {
                    loginUser(txt_email, txt_passwort);
                }
            }
        });
    }

    /**
     * Loginabfrage an der Datenbank
     * bekommt E-Mail und Passwort als String übergeben
     * Firebase Methode .signInWithEmailAndPassword führt die eigentliche Abfrage durch
     * gibt dem Nutzer eine Toast-Nachricht zurück, wenn der Login erfolgreich war
     * @param email
     * @param passwort
     */
    private void loginUser(String email, String passwort) {
        auth.signInWithEmailAndPassword(email, passwort).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                /**
                 * Anzeigen eines Ladebildschirmes als Nutzerfeedback
                 */
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_view);
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );

                Toast.makeText(LoginActivity.this, "Login erfolgreich!", Toast.LENGTH_SHORT).show();

                //Loggingbefehl zum auslesen ob Anmeldung erfolgreich
                Log.i("success", "Login erfolgreich");
                openMainActivity();
            }
        });
    }

    /**
     * öffnet die Main-Activity mit den Inhalten
     */
    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}