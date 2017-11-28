package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
 * Created by sboyd on 11/28/2017.
 */

public class TasksCompletedFragment extends ListFragment {

    private FragmentListener listener;
    private DatabaseReference db;
    private ArrayList<Task> tasks;
    private List<HashMap<String,String>> aList;
    private ListView list;
    private String key;

    public TasksCompletedFragment(){this.listener=null;this.key=" ";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_taskscompleted, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        db = FirebaseDatabase.getInstance().getReference().child("tasks").child(key);
        tasks = new ArrayList<>();
        list = (ListView)view.findViewById(R.id.tasks_completed);
        aList = new ArrayList<HashMap<String,String>>();


        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (long i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                    tasks.add(dataSnapshot.child(Long.toString(i + 1)).getValue(Task.class));
                }

                for(int i = 0; i < tasks.size();i++)
                {
                    HashMap<String, String> hm = new HashMap<String,String>();

                    if(!tasks.get(i).isActive())
                    {
                        hm.put("description",tasks.get(i).getDescription());
                        hm.put("date","Completion date: " + tasks.get(i).getEndDate());
                        hm.put("level","Difficulty: "+ tasks.get(i).getLevel());
                        hm.put("points","Points: " + Integer.toString(tasks.get(i).getPoints()));
                        aList.add(hm);
                    }
                }

                String[]keys = {"description","date","level","points"};
                int[]ids = {R.id.description,R.id.date,R.id.level,R.id.points};

                SimpleAdapter adapter = new SimpleAdapter(getActivity(),aList,R.layout.list_view_model,keys,ids);
                list.setAdapter(adapter);


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

    public interface FragmentListener{

    }
}
