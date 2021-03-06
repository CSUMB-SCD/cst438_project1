package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import group_project.csumb.com.autitrak.R;

/**
 * Created by sboyd on 11/9/2017.
 */

public class LoginFragment extends Fragment{

    private FragmentListener listener;
    private FirebaseAuth auth;
    private String key;
    private Button signin;
    private EditText email;
    private  EditText password;

    public LoginFragment(){this.listener=null;}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_login, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        signin = view.findViewById(R.id.login_page_button);
        email = view.findViewById(R.id.email_editText);
        password = view.findViewById(R.id.password_editText);

        signin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email_txt = email.getText().toString().trim();
                String password_txt = password.getText().toString().trim();

                auth.signInWithEmailAndPassword(email_txt, password_txt).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            if(listener!=null)
                            {
                                key = encodeKey(auth.getCurrentUser().getEmail());
                                listener.onSuccess(true,key);
                            }
                        }
                        else
                        {
                            if(listener!=null)
                            {
                                listener.onSuccess(false,"");
                            }
                        }
                    }
                });
            }
        });
    }

    public void setOnClickListener(FragmentListener listener)
    {
        this.listener = listener;
    }

    public interface FragmentListener{
        void onSuccess(boolean in,String key);
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
