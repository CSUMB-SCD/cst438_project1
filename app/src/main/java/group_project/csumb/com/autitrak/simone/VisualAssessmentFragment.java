package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import group_project.csumb.com.autitrak.R;

/**
 * Created by sboyd on 11/28/2017.
 */

public class VisualAssessmentFragment extends Fragment {

    private FragmentListener listener;
    private ImageView img;
    private RadioGroup answers;
    private Button next_bttn;
    private TextView question;

    public VisualAssessmentFragment(){this.listener=null;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_visual_assessment, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        img = (ImageView)view.findViewById(R.id.scenario_img);
        answers = (RadioGroup)view.findViewById(R.id.questions);
        next_bttn = (Button)view.findViewById(R.id.v_next_bttn);
        question = (TextView)view.findViewById(R.id.q1);

        next_bttn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(listener!=null)
                {
                    if(answers.getCheckedRadioButtonId()==-1)
                    {
                        listener.response(false,0);
                    }
                    else{
                        listener.response(true,answers.getCheckedRadioButtonId());
                    }
                }
            }
        });


    }

    public void setOnClickListener(FragmentListener listener)
    {
        this.listener = listener;
    }

    public void nextQuestion(int q_num){
        switch(q_num){

            case 2:

                break;

            case 3:
                break;
        }
    }

    public interface FragmentListener{
        void response(boolean selected, int id);
    }
}
