package group_project.csumb.com.autitrak;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

public class FragmentActivity extends android.support.v4.app.FragmentActivity{

    private FragmentManager fm;

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

            MainFragment lf = new MainFragment();

            fm.beginTransaction().add(R.id.fragment_container,lf).commit();


            //Attach listener
            lf.setOnClickListener(new MainFragment.FragmentListener(){
                @Override
                public void onClicked(View v)
                {
                    if(v.getId() == R.id.login_fragment_button)
                    {
                        fm.beginTransaction().replace(R.id.fragment_container,new LoginFragment()).commit();
                    }
                    else if(v.getId() == R.id.signup_fragment_button)
                    {

                    }
                }
            });
        }
    }
}
