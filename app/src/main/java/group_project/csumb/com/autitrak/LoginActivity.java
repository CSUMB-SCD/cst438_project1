package group_project.csumb.com.autitrak;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button login;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference();

        email = (EditText)findViewById(R.id.email_editText);
        password = (EditText)findViewById(R.id.password_editText);
        login = (Button)findViewById(R.id.login_page_button);

        login.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
    }

    private void signIn(String email_txt, String password_txt)
    {
        auth.signInWithEmailAndPassword(email_txt, password_txt)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    if(task.isSuccessful())
                    {

                        FirebaseUser user = auth.getCurrentUser();
                        Toast.makeText(LoginActivity.this,"Logged in: ",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Login fail: ",Toast.LENGTH_SHORT).show();
                    }
                }
                });
    }

    @Override
    public void onClick(View v) {
        String email_txt = email.getText().toString().trim();
        String password_txt = password.getText().toString().trim();

        if(v.getId() == login.getId())
        {
            signIn(email_txt,password_txt);
        }
    }
}
