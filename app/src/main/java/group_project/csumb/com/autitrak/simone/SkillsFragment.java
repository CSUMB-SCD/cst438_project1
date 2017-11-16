package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.Map;

import group_project.csumb.com.autitrak.R;


public class SkillsFragment extends Fragment{

    private FragmentListener listener;
    private DatabaseReference db;
    private TextView interpersonal_textView;
    private TextView intrapersonal_textView;
    private TextView test;
    private Individual indiv;
    private String key;
    Map<String,Integer> skills;

    public SkillsFragment(){this.listener=null;key="";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_skills, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        db = FirebaseDatabase.getInstance().getReference().child("individuals");
        interpersonal_textView = (TextView)view.findViewById(R.id.interpersonal_textView);
        intrapersonal_textView = (TextView)view.findViewById(R.id.intrapersonal_textView);


        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                indiv = dataSnapshot.child(key).getValue(Individual.class);


                interpersonal_textView.setText(String.format("%s",indiv.getInterpersonal()));
                intrapersonal_textView.setText(String.format("%s",indiv.getIntrapersonal()));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public interface FragmentListener
    {

    }
}
