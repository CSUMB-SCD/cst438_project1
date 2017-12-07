package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import group_project.csumb.com.autitrak.R;


public class AssessmentResultsFragment extends Fragment {
    private TextView score_textview;
    private DatabaseReference db;
    private String key;
    private long score;
    private long total_points;
    private long interpersonal_points;
    private String level;


    public AssessmentResultsFragment(){this.score=0;this.key=" ";}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_individual_assessment_results, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        score_textview = (TextView)view.findViewById(R.id.individual_score);
        score_textview.setText(String.format("%s pts",score));
        db = FirebaseDatabase.getInstance().getReference().child("individuals").child(key);


        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                total_points = dataSnapshot.child("totalpoints").getValue(Long.class)+score;
                interpersonal_points = Long.parseLong(dataSnapshot.child("skill_levels").child("interpersonal_points").getValue().toString())+score;


                if(interpersonal_points > 200 && interpersonal_points < 500)
                {
                    level = "intermediate";
                }
                else if(interpersonal_points > 500)
                {
                    level = "advanced";
                }
                else
                {
                    level = dataSnapshot.child("skill_levels").child("interpersonal").getValue().toString();
                }

                if(dataSnapshot.child("skill_levels").child("interpersonal").getValue().equals("beginner") && level.equals("intermediate")
                        || dataSnapshot.child("skill_levels").child("interpersonal").getValue().equals("intermediate") && level.equals("advanced"))
                {
                    Toast.makeText(getActivity(),"Level Up",Toast.LENGTH_LONG).show();
                }

                db.child("totalpoints").setValue(total_points);
                db.child("skill_levels").child("interpersonal_points").setValue(Long.toString(interpersonal_points));
                db.child("skill_levels").child("interpersonal").setValue(level);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setScore(long score){this.score=score;}

    public void setKey(String key){this.key=key;}


}
