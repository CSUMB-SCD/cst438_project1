package group_project.csumb.com.autitrak;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sboyd on 11/9/2017.
 */

public class MainFragment extends Fragment{

    private FragmentListener listener;

    public MainFragment()
    {
        this.listener=null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_main, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Button login = (Button)view.findViewById(R.id.login_fragment_button);
        Button signup = (Button)view.findViewById(R.id.signup_fragment_button);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(listener!=null)
                {
                    listener.onClicked(v);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                {
                    listener.onClicked(v);
                }
            }
        });

    }

    public void setOnClickListener(FragmentListener listener)
    {
        this.listener = listener;
    }

    public interface FragmentListener{
        public void onClicked(View v);
    }
}
