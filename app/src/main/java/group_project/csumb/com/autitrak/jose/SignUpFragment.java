package group_project.csumb.com.autitrak.jose;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import group_project.csumb.com.autitrak.R;
import group_project.csumb.com.autitrak.simone.User;

import static android.content.ContentValues.TAG;

public class SignUpFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private EditText firstName;
    private EditText lastName;
    private EditText emailTextEdit;
    private EditText username;
    private EditText passwordTextEdit;
    private FirebaseAuth auth;
    private Button signUp;
    private FirebaseAuth mAuth;
    private RadioButton b1;
    private RadioButton b2;
    private Button next;
    private int type;
    private String key;
    private String email;

    public SignUpFragment() {
        this.mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            firstName = (EditText)view.findViewById(R.id.firstName);
            lastName = (EditText)view.findViewById(R.id.lastName);
            username = (EditText)view.findViewById(R.id.username);
            emailTextEdit = (EditText)view.findViewById(R.id.email_editText);
            passwordTextEdit = (EditText)view.findViewById(R.id.password_editText);
            signUp = (Button)view.findViewById(R.id.signUp);
            email = emailTextEdit.toString();
            key = encodeKey(email);

        mAuth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    if(mListener!=null)
                    {
                        mListener.onSuccess(true,key);
                    }
                }
                else
                {
                    if(mListener!=null)
                    {
                        mListener.onSuccess(false,"");
                    }
                }
            }
        });
    }

    public void setType (int t){
        type = t;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

  private void createAccount(String email,String password, String username, String first_name, String last_name, int type) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

      final String e = email;
      final String f = first_name;
      final String l = last_name;
      final String u = username;
      final String p = password;
      final int t = type;

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            writeNewUser(e,f,l,u,p,t);
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
    private boolean validateForm() {
        boolean valid = true;
        String email = emailTextEdit.getText().toString();

        if (TextUtils.isEmpty(email)) {
            emailTextEdit.setError("Required.");
            valid = false;
        } else {
            emailTextEdit.setError(null);
        }
        String password = passwordTextEdit.getText().toString();

        if (TextUtils.isEmpty(password)) {
            passwordTextEdit.setError("Required.");
            valid = false;
        } else {
            passwordTextEdit.setError(null);
        }
        return valid;
    }

    private void writeNewUser(String emailTextEdit, String firstName, String lastfName, String username, String passwordTextEdit,
                              int type) {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("users");
        User user;
        Map<String,Object> skills = new HashMap<>();
        skills.put("interpersonal","beginner");
        skills.put("interpersonal_points","0");
        skills.put("intrapersonal","beginner");
        skills.put("intrapersonal_points","0");


        if (type == 1){user = new User(firstName, 1, emailTextEdit, true);
            db = FirebaseDatabase.getInstance().getReference().child("individuals");
            db.push().child("totalpoints").setValue(0);
            db.push().child("skill_levels").setValue(skills);

            }else{
            user = new User(firstName, 0, emailTextEdit, true);
        }
        db.child(encodeKey(emailTextEdit)).setValue(user);
    }
    public interface OnFragmentInteractionListener {
        void onSuccess(boolean in,String key);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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