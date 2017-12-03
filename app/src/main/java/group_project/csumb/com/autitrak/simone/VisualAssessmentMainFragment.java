package group_project.csumb.com.autitrak.simone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import group_project.csumb.com.autitrak.R;


public class VisualAssessmentMainFragment extends Fragment {

    Button beginner;
    Button intermediate;
    Button advanced;
    VisualAssessmentFragment vf;

    public VisualAssessmentMainFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_individual_visual_assessment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        beginner = (Button)view.findViewById(R.id.beginner_start);
        intermediate = (Button)view.findViewById(R.id.intermediate_start);
        advanced = (Button)view.findViewById(R.id.advanced_start);
        vf = new VisualAssessmentFragment();

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.setDifficulty(0);
                getChildFragmentManager().beginTransaction().replace(R.id.vf_main,vf).commit();
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.setDifficulty(1);
                getChildFragmentManager().beginTransaction().replace(R.id.vf_main,vf).commit();
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.setDifficulty(2);
                getChildFragmentManager().beginTransaction().replace(R.id.vf_main,vf).commit();
            }
        });
    }
}
