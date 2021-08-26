package de.medieninformatik.rezepteapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Lucas Kahl m27606
 * Semesterabgabe Prog4 Android SoSe 2021
 */

/**
 * StartActivity ist die zuerst öffnende Activity der App
 * Hier befinden sich eine Überschrift, ein Bild und jeweils ein Button für Login und Registrierung
 */
public class StartActivity extends AppCompatActivity {

    /**
     * Initialisierung der notwendigen Parameter
     */
    private Button loginButton;
    private Button registButton;
    private TextView tvlogin;
    private TextView tvregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        /**
         * Verbindung der GUI-Elemente via Id mit den Parametern
         */
        loginButton = findViewById(R.id.bt_login_login);
        registButton = findViewById(R.id.bt_regist);


        /**
         * OnClick-Methode des Regisrieren-Buttons
         * ruft openRegistration auf
         */
        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });



        /**
         * OnClick-Methode des Login-Buttons
         * ruft openLogin auf
         */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

    }

    /**
     * öffnet LoginActivity
     */
    private void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * öffnet RegisterActivity
     */
    private void openRegistration() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void openLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}