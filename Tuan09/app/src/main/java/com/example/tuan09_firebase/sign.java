package com.example.tuan09_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class sign extends AppCompatActivity {
    TextView textView;
    Button btnlogin;
    EditText email;
    EditText pass;

    private static final int REQ_ONE_TAP = 2;  // Can be any integer unique to the Activity.
    private boolean showOneTapUI = true;
    private static final int RC_SIGN_IN = 0;
    private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        textView = findViewById(R.id.txtgg);
        mauth= FirebaseAuth.getInstance();
        btnlogin=findViewById(R.id.btnSignIn);
        email=findViewById(R.id.txtemailsign);
        pass=findViewById(R.id.edtpass);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
login();
            }
        });

    }
    private void login(){
        String emails,passw;
        emails=email.getText().toString();
        passw=pass.getText().toString();
        mauth.signInWithEmailAndPassword(emails,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(sign.this,home.class);
                    startActivity(intent);
                }
            }
        });
    }
}
