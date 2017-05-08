package slider.yassinelhadedy.github.com.cafenews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText user_name;
    private EditText user_pass;
    private Button login;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView deriverlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        deriverlogin=(TextView)findViewById(R.id.deriver_login5);
        user_name=(EditText) findViewById(R.id.input_email);
        user_pass=(EditText)findViewById(R.id.input_password);
        login=(Button)findViewById(R.id.btn_login);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
         //   Toast.makeText(LoginActivity.this,firebaseAuth.getCurrentUser().getDisplayName().toString(),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();


        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=user_name.getText().toString();
                String pass=user_pass.getText().toString();
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Sucess login",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                         //   Toast.makeText(LoginActivity.this,firebaseAuth.getCurrentUser().getDisplayName().toString(),Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();

                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Faild login",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }

                    }
                });

            }
        });
        deriverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,FacebookLogin.class));
            }
        });

    }
}
