package group_project.csumb.com.autitrak;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import group_project.csumb.com.autitrak.simone.LoginFragment;
import group_project.csumb.com.autitrak.simone.MainFragment;
import group_project.csumb.com.autitrak.simone.SkillsFragment;

public class FragmentActivity extends android.support.v4.app.FragmentActivity{

    private FragmentManager fm;
    private MainFragment mf;
    private LoginFragment lf;
    private SkillsFragment sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        //Check if frame layout exist
        if(findViewById(R.id.fragment_container)!=null)
        {
            //????
            if(savedInstanceState!=null)
            {
                return;
            }


            //Start activity here
            fm = getSupportFragmentManager();

            mf = new MainFragment();
            lf = new LoginFragment();
            sf = new SkillsFragment();

            //Start MainFragment onCreateView method
            fm.beginTransaction().add(R.id.fragment_container,mf).commit();


            //Attach listener
            mf.setOnClickListener(new MainFragment.FragmentListener(){
                @Override
                public void onClicked(View v)
                {
                    if(v.getId() == R.id.login_fragment_button)
                    {
                        fm.beginTransaction().replace(R.id.fragment_container,lf).commit();
                    }
                    else if(v.getId() == R.id.signup_fragment_button)
                    {

                    }
                }
            });


            lf.setOnClickListener(new LoginFragment.FragmentListener(){

                //Callback created in LoginFragment class, passes bool to check if FirebaseAuth signin successful
                @Override
                public void onSuccess(boolean in,String key) {
                    if(in)
                    {

                        Toast.makeText(FragmentActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                        sf.setKey(key);
                        fm.beginTransaction().replace(R.id.fragment_container,sf).commit();
                    }
                    else
                    {
                        Toast.makeText(FragmentActivity.this,"Login failed!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
