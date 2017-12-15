package group_project.csumb.com.autitrak.jose;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import group_project.csumb.com.autitrak.R;
import group_project.csumb.com.autitrak.simone.User;

import static android.content.ContentValues.TAG;

public class SignUpFragment extends Fragment {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signUp;
    private FirebaseAuth mAuth;
    private int type;
    private String key;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

    public SignUpFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

            firstNameEditText = (EditText)view.findViewById(R.id.firstName);
            lastNameEditText = (EditText)view.findViewById(R.id.lastName);
            emailEditText = (EditText)view.findViewById(R.id.email);
            usernameEditText = (EditText)view.findViewById(R.id.username);
            passwordEditText = (EditText)view.findViewById(R.id.password);
            signUp = (Button)view.findViewById(R.id.signUp);
            mAuth = FirebaseAuth.getInstance();

            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firstname = firstNameEditText.getText().toString().trim();
                    lastname = lastNameEditText.getText().toString().trim();
                    email = emailEditText.getText().toString().trim();
                    username = usernameEditText.getText().toString().trim();
                    password = passwordEditText.getText().toString().trim();

                    if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty())
                    {
                        createAccount(email,password,username,firstname,lastname,type);
                    }
                }
            });

    }

    public void setType (int t){
        type = t;
    }


  private void createAccount(String email,String password, String username, String first_name, String last_name, int type) {
        Log.d(TAG, "createAccount:" + email);

      final String e = email;
      final String f = first_name;
      final String l = last_name;
      final int t = type;

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            //writeNewUser(e,f,l,t);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                        //hideProgressDialog();
                    }
                });
    }


    private void writeNewUser(String email, String firstName, String lastName,
                              int type) {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("users");
        User user;
        Map<String,Object> skills = new HashMap<>();
        skills.put("interpersonal","beginner");
        skills.put("interpersonal_points","0");
        skills.put("intrapersonal","beginner");
        skills.put("intrapersonal_points","0");


        if (type == 1){user = new User(firstName, 1, email, true);
            db = FirebaseDatabase.getInstance().getReference().child("individuals");
            db.push().child("totalpoints").setValue(0);
            db.push().child("skill_levels").setValue(skills);

            }else{
            user = new User(firstName+ " " + lastName, 0, email, true);
        }
        db.child(encodeKey(email)).setValue(user);
    }




    public String encodeKey(String k)
    {
        return k.replace("%", "%25").replace(".","%2E").replace("#","%23").replace("$","%24").replace("/","%2F");
    }

    public String decodeKey(String k)
    {
        return k.replace("%25", "%").replace("%2E",".").replace("%23","#").replace("%24","$").replace("%2F","/");
    }
}