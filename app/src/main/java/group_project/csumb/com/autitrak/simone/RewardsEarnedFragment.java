package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import group_project.csumb.com.autitrak.R;

/**
 * Created by sboyd on 12/5/2017.
 */

public class RewardsEarnedFragment extends ListFragment {

    private DatabaseReference db;
    private ArrayList<Task> tasks;
    private List<HashMap<String,String>> aList;
    private ListView list;
    private String key;

    public RewardsEarnedFragment(){this.key=" ";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_individual_rewards_earned, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        db = FirebaseDatabase.getInstance().getReference().child("tasks").child(key);
        tasks = new ArrayList<>();
        list = (ListView)view.findViewById(R.id.individual_tasks_completed);
        aList = new ArrayList<HashMap<String,String>>();

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

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
}
