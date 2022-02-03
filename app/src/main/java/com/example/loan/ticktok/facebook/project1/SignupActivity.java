package com.example.loan.ticktok.facebook.project1;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    private EditText email,pass;
    private Button login;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        email =findViewById(R.id.etemail);
        pass = findViewById(R.id.etpass);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Login();

            }
        });


    }
    public void Login()
    {

        String etemail = email.getText().toString();
        String etpass = pass.getText().toString();




        if(TextUtils.isEmpty(etemail))
        {
            email.setError("Enter your Email");
            return;
        }

        else if(TextUtils.isEmpty(etpass))
        {
            pass.setError("Enter your password");
            return;
        }


        else if(pass.length()<5)
        {
            email.setError("Password must be greater than 4");
            return;
        }



        progressDialog.setMessage("Please wait....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(etemail,etpass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignupActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this,party_profile.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}