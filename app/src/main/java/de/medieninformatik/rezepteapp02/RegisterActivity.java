package de.medieninformatik.rezepteapp02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText passwort;
    private Button register;


    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        email = findViewById(R.id.et_email_login);
        passwort = findViewById(R.id.et_passwort_login);
        register = findViewById(R.id.bt_login_login);

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


        /**register.setOnClickListener(v -> {

            String txt_email = email.getText().toString();
            String txt_passwort = passwort.getText().toString();

            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_passwort)) {
                Toast.makeText(RegisterActivity.this, "leeres Pflichtfeld!", Toast.LENGTH_SHORT).show();
            } else if (txt_passwort.length() < 6) {
                Toast.makeText(RegisterActivity.this, "Passwort zu kurz!", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(txt_email, txt_passwort);

            }
        });*/
    }

    private void registerUser(String email, String passwort) {
        auth.createUserWithEmailAndPassword(email,passwort).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Registrierung erfolgreich!" , Toast.LENGTH_SHORT).show();
                    openMainActivity();
                }else {
                    Toast.makeText(RegisterActivity.this,"Registrierung fehlgeschlagen!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}