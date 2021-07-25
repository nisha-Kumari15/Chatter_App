package com.example.chatter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget extends AppCompatActivity {
    EditText emailForget;
    Button registerPass;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        emailForget = findViewById(R.id.emailForget);
        registerPass = findViewById(R.id.resetPass);
        auth = FirebaseAuth.getInstance();
        registerPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = emailForget.getText().toString();
                if(!mail.equals(""))
                {
                    passwordreset(mail);
                }
            }
        });
    }

    private void passwordreset(String mail) {
        auth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Forget.this, "Please Check your mail", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Forget.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}