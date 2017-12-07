package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import group_project.csumb.com.autitrak.R;


public class AssessmentResultsFragment extends Fragment {
    private TextView score_textview;
    private int score;

    public AssessmentResultsFragment(){this.score=0;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_individual_assessment_results, parent, false);
        score_textview = (TextView)v.findViewById(R.id.individual_score);
        score = getArguments().getInt("score");
        score_textview.setText(String.format("%s pts",score));
        // Defines the xml file for the fragment
        return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }


}
