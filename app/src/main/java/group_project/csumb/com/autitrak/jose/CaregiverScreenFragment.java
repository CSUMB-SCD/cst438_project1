package group_project.csumb.com.autitrak.jose;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import group_project.csumb.com.autitrak.R;

public class CaregiverScreenFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private RadioButton yes_button;
    private RadioButton no_button;
    private Button next;
    private int type;


    public CaregiverScreenFragment (){this.mListener = null;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_caregiver_screen, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        yes_button = view.findViewById(R.id.yes_button);
        no_button = view.findViewById(R.id.no_button);
        next = view.findViewById(R.id.next_button);

        next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(yes_button.isChecked()) {
                    // CODE THAT WILL SET TYPE TO YES
                    type = 1;
                    mListener.changeFragment(type);
                }
                else if(no_button.isChecked()) {
                    // CODE THAT WILL SET TYPE TO No
                    type = 0;
                    mListener.changeFragment(type);


                }
            }
        });
    }


    public void setOnClickListener(OnFragmentInteractionListener mListener)
    {
        this.mListener = mListener;
    }
    public interface OnFragmentInteractionListener {
        void changeFragment(int type);
    }
}