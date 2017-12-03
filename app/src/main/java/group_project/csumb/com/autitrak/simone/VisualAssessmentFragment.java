package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import group_project.csumb.com.autitrak.R;

/**
 * Created by sboyd on 11/28/2017.
 */

public class VisualAssessmentFragment extends Fragment {


    private ImageView img;
    private RadioGroup answers;
    private RadioButton a1;
    private RadioButton a2;
    private RadioButton a3;
    private RadioButton a4;
    private Button next_bttn;
    private TextView question;
    private int difficulty;
    private int score;
    private int q_num;

    public VisualAssessmentFragment(){this.score=0;q_num=1;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_individual_visual_assessment, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        img = (ImageView)view.findViewById(R.id.q_img);
        answers = (RadioGroup)view.findViewById(R.id.questions);
        next_bttn = (Button)view.findViewById(R.id.v_next_bttn);
        question = (TextView)view.findViewById(R.id.q);
        a1 = (RadioButton)view.findViewById(R.id.a_1);
        a2= (RadioButton)view.findViewById(R.id.a_2);
        a3 = (RadioButton)view.findViewById(R.id.a_3);
        a4 = (RadioButton)view.findViewById(R.id.a_4);
        score = 0;

        if(difficulty==0) {

                question.setText(R.string.q1);
                img.setImageResource(R.drawable.q1_beginner);
                a1.setText(R.string.a1_opt1);
                a2.setText(R.string.a1_opt2);
                a3.setText(R.string.a1_opt3);
                a4.setText(R.string.a1_opt4);

        }
        else if(difficulty == 1)
        {

        }
        else if(difficulty == 2)
        {

        }

        next_bttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(q_num == 1 && a3.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 2 && a2.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 3 && a4.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 4 && a1.isChecked())
                {
                    score+=5;
                }

                answers.clearCheck();
                if(q_num < 5) {

                    q_num++;

                }
                if (q_num == 2) {
                    question.setText(R.string.q2);
                    img.setImageResource(R.drawable.q2_beginner);
                    a1.setText(R.string.a2_opt1);
                    a2.setText(R.string.a2_opt2);
                    a3.setText(R.string.a2_opt3);
                    a4.setText(R.string.a2_opt4);

                } else if (q_num == 3) {
                    question.setText(R.string.q3);
                    img.setImageResource(R.drawable.q3_beginner);
                    a1.setText(R.string.a3_opt1);
                    a2.setText(R.string.a3_opt2);
                    a3.setText(R.string.a3_opt3);
                    a4.setText(R.string.a3_opt4);

                    if(a4.isChecked())
                    {
                        score+=5;
                    }
                } else if (q_num == 4) {
                    question.setText(R.string.q4);
                    img.setImageResource(R.drawable.q4_beginner);
                    a1.setText(R.string.a4_opt1);
                    a2.setText(R.string.a4_opt2);
                    a3.setText(R.string.a4_opt3);
                    a4.setText(R.string.a4_opt4);

                    if(a1.isChecked())
                    {
                        score+=5;
                    }
                }


                else
                {
                    AssessmentResultsFragment af = new AssessmentResultsFragment();
                    Bundle b = new Bundle();
                    b.putInt("score",score);
                    af.setArguments(b);
                    getChildFragmentManager().beginTransaction().replace(R.id.v_assess,af).commit();
                }
            }

        });


    }





    public void setDifficulty(int difficulty){this.difficulty=difficulty;}

}
