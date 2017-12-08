package group_project.csumb.com.autitrak.simone;

import android.graphics.drawable.AnimationDrawable;
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
    private ImageView refresh;
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
    private AnimationDrawable advanced_imgview;
    private String key;

    public VisualAssessmentFragment(){this.score=0;q_num=1;key = " ";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_individual_visual_assessment, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        img = (ImageView)view.findViewById(R.id.q_img);
        refresh = (ImageView)view.findViewById(R.id.refresh);
        answers = (RadioGroup)view.findViewById(R.id.questions);
        next_bttn = (Button)view.findViewById(R.id.v_next_bttn);
        question = (TextView)view.findViewById(R.id.q);
        a1 = (RadioButton)view.findViewById(R.id.a_1);
        a2= (RadioButton)view.findViewById(R.id.a_2);
        a3 = (RadioButton)view.findViewById(R.id.a_3);
        a4 = (RadioButton)view.findViewById(R.id.a_4);
        score = 0;

        if(difficulty==0) {

                question.setText(R.string.b_q1);
                img.setImageResource(R.drawable.q1_beginner);
                a1.setText(R.string.b_a1_opt1);
                a2.setText(R.string.b_a1_opt2);
                a3.setText(R.string.b_a1_opt3);
                a4.setText(R.string.b_a1_opt4);
                score+=10;
        }
        else if(difficulty == 1)
        {
            question.setText(R.string.i_q1);
            img.setImageResource(R.drawable.q1_intermediate);
            a1.setText(R.string.i_a1_opt1);
            a2.setText(R.string.i_a1_opt2);
            a3.setText(R.string.i_a1_opt3);
            a4.setText(R.string.i_a1_opt4);
            score+=20;
        }
        else if(difficulty == 2)
        {
            refresh.setVisibility(View.VISIBLE);
            img.setBackgroundResource(R.drawable.assessment_animations);
            advanced_imgview = (AnimationDrawable)img.getBackground();
            question.setText(R.string.a_q1);
            a1.setText(R.string.a_q1_opt1);
            a2.setText(R.string.a_q1_opt2);
            a3.setText(R.string.a_q1_opt3);
            a4.setText(R.string.a_q1_opt4);
            advanced_imgview.start();



            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    advanced_imgview.setVisible(true,true);
                    advanced_imgview.selectDrawable(0);
                    advanced_imgview.start();
                }
            });

            score+=40;

        }

        next_bttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(q_num == 1 && difficulty == 0 && a3.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 2 && difficulty == 0 && a2.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 3 && difficulty == 0 && a4.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 4 && difficulty == 0 && a1.isChecked())
                {
                    score+=5;
                }
                else if(q_num == 1 && difficulty == 1 && a2.isChecked())
                {
                    score+=10;
                }
                else if(q_num == 2 && difficulty == 1 && a1.isChecked())
                {
                    score+=10;
                }
                else if(q_num == 3 && difficulty == 1 && a3.isChecked())
                {
                    score+=10;
                }
                else if(q_num == 4 && difficulty == 1 && a2.isChecked())
                {
                    score+=10;
                }
                else if(q_num == 1 && difficulty == 2 && a2.isChecked())
                {
                    score+=20;
                }


                if(q_num < 5) {

                    q_num++;

                }
                if (q_num == 2 && difficulty == 0) {
                    answers.clearCheck();
                    question.setText(R.string.b_q2);
                    img.setImageResource(R.drawable.q2_beginner);
                    a1.setText(R.string.b_a2_opt1);
                    a2.setText(R.string.b_a2_opt2);
                    a3.setText(R.string.b_a2_opt3);
                    a4.setText(R.string.b_a2_opt4);

                } else if (q_num == 3 && difficulty ==0 ) {
                    answers.clearCheck();
                    question.setText(R.string.b_q3);
                    img.setImageResource(R.drawable.q3_beginner);
                    a1.setText(R.string.b_a3_opt1);
                    a2.setText(R.string.b_a3_opt2);
                    a3.setText(R.string.b_a3_opt3);
                    a4.setText(R.string.b_a3_opt4);

                } else if (q_num == 4 && difficulty == 0) {
                    answers.clearCheck();
                    question.setText(R.string.b_q4);
                    img.setImageResource(R.drawable.q4_beginner);
                    a1.setText(R.string.b_a4_opt1);
                    a2.setText(R.string.b_a4_opt2);
                    a3.setText(R.string.b_a4_opt3);
                    a4.setText(R.string.b_a4_opt4);

                }
                else if(q_num == 2 && difficulty == 1)
                {
                    answers.clearCheck();
                    question.setText(R.string.i_q2);
                    img.setImageResource(R.drawable.q2_intermediate);
                    a1.setText(R.string.i_a2_opt1);
                    a2.setText(R.string.i_a2_opt2);
                    a3.setText(R.string.i_a2_opt3);
                    a4.setText(R.string.i_a2_opt4);
                }
                else if(q_num == 3 && difficulty == 1)
                {
                    answers.clearCheck();
                    question.setText(R.string.i_q3);
                    img.setImageResource(R.drawable.q3_intermediate);
                    a1.setText(R.string.i_a3_opt1);
                    a2.setText(R.string.i_a3_opt2);
                    a3.setText(R.string.i_a3_opt3);
                    a4.setText(R.string.i_a3_opt4);
                }
                else if(q_num == 4 && difficulty == 1)
                {
                    answers.clearCheck();
                    question.setText(R.string.i_q4);
                    img.setImageResource(R.drawable.q4_intermediate);
                    a1.setText(R.string.i_a4_opt1);
                    a2.setText(R.string.i_a4_opt2);
                    a3.setText(R.string.i_a4_opt3);
                    a4.setText(R.string.i_a4_opt4);
                }
                else
                {
                    AssessmentResultsFragment af = new AssessmentResultsFragment();
                    Bundle b = new Bundle();
                    b.putInt("score",score);
                    b.putString("key",key);
                    af.setArguments(b);
                    getChildFragmentManager().beginTransaction().replace(R.id.v_assess,af).commit();
                }
            }

        });


    }




    public void setKey(String key){this.key=key;}

    public void setDifficulty(int difficulty){this.difficulty=difficulty;}

}
