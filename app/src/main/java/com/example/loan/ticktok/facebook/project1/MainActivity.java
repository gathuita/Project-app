package com.example.loan.ticktok.facebook.project1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
    private EditText user,email,pass,confirm;
    private Button register;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.etuser);
        email =findViewById(R.id.etemail);
        pass = findViewById(R.id.etpass);
        confirm = findViewById(R.id.etconfirm);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Register();

            }
        });


    }
    public void Register()
    {
        String etuser = user.getText().toString();
        String etemail = email.getText().toString();
        String etpass = pass.getText().toString();
        String etconfirm = confirm.getText().toString();

        if(TextUtils.isEmpty(etuser))
        {
            user.setError("Enter your full name");
            return;
        }

        else if(TextUtils.isEmpty(etemail))
        {
            email.setError("Enter your Email");
            return;
        }

        else if(TextUtils.isEmpty(etpass))
        {
            pass.setError("Enter your password");
            return;
        }

        else if(TextUtils.isEmpty(etconfirm))
        {
            confirm.setError("Confirm your password");
            return;
        }

        else if(pass.equals(etconfirm))
        {
            confirm.setError("Password mismatch");
            return;
        }

        else if(pass.length()<5)
        {
            pass.setError("Password must be greater than 4");
            return;
        }

        else if(isVallidEmail(etemail))
        {
            email.setError("Invalid Email");
            return;
        }

        progressDialog.setMessage("Please wait....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(etemail,etpass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,party_profile.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                };

            }
        });

    }

    private boolean isVallidEmail(CharSequence target)
    {
        return TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }
}