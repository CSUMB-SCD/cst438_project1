package group_project.csumb.com.autitrak;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FragmentActivity extends android.support.v4.app.FragmentActivity{

    private FragmentManager fm;
    private MainFragment mf;
    private LoginFragment lf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        if(findViewById(R.id.fragment_container)!=null)
        {

            if(savedInstanceState!=null)
            {
                return;
            }


            //Start activity here
            fm = getSupportFragmentManager();

            mf = new MainFragment();
            lf = new LoginFragment();

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

                @Override
                public void onSuccess(boolean in) {
                    if(in)
                    {
                        Toast.makeText(FragmentActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                        //Replace with todo list fragment
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
