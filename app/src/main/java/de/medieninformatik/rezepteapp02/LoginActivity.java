package de.medieninformatik.rezepteapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText passwort;
    private Button login;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_email_login);
        passwort = findViewById(R.id.et_passwort_login);
        login = findViewById(R.id.bt_login_login);

        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_passwort = passwort.getText().toString();
                loginUser(txt_email, txt_passwort);
            }
        });
    }

    private void loginUser(String email, String passwort) {
        auth.signInWithEmailAndPassword(email, passwort).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login erfolgreich!", Toast.LENGTH_SHORT).show();
                openMainActivity();
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}