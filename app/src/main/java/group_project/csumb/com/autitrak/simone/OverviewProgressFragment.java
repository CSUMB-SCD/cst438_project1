package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import group_project.csumb.com.autitrak.R;



public class OverviewProgressFragment extends Fragment {

    private FragmentListener listener;
    private DatabaseReference db;
    private BarChart chart;
    private ArrayList<Task> tasks;
    private TextView points_earned;
    private String key;


    public OverviewProgressFragment(){this.listener=null;this.key=" ";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_overview_progress, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        db = FirebaseDatabase.getInstance().getReference().child("tasks").child(key);
        tasks = new ArrayList<>();
        points_earned = (TextView)view.findViewById(R.id.points_placeholder);
        chart = (BarChart)view.findViewById(R.id.chart);
        chart.setNoDataText(" ");

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(long i = 0; i < dataSnapshot.getChildrenCount(); i++)
                {
                    tasks.add(dataSnapshot.child(Long.toString(i+1)).getValue(Task.class));
                }

                int totalpoints = 0;
                int beginner_count = 0;
                int intermediate_count = 0;
                int advanced_count = 0;

                for(int i = 0; i < tasks.size(); i++)
                {
                    if(!tasks.get(i).isActive()) {
                        totalpoints += tasks.get(i).getPoints();

                        if(tasks.get(i).getLevel().equals("beginner"))
                        {
                            beginner_count++;
                        }
                        else if(tasks.get(i).getLevel().equals("intermediate"))
                        {
                            intermediate_count++;
                        }
                        else if(tasks.get(i).getLevel().equals("advanced"))
                        {
                            advanced_count++;
                        }
                    }

                }

                points_earned.setText(String.format("%s",totalpoints));
                points_earned.setVisibility(View.VISIBLE);

                ArrayList<BarEntry>entries = new ArrayList<>();
                entries.add(new BarEntry(beginner_count,0));
                entries.add(new BarEntry(intermediate_count,1));
                entries.add(new BarEntry(advanced_count,2));

                ArrayList<String>labels = new ArrayList<>();
                labels.add("Beginner");
                labels.add("Intermediate");
                labels.add("Advanced");
                BarDataSet data_set = new BarDataSet(entries,"Completed Tasks");
                data_set.setColor(R.color.bar_color);
                data_set.setValueTextSize(14);
                BarData data = new BarData(labels,data_set);

                chart.setData(data);


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
