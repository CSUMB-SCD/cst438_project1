package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import group_project.csumb.com.autitrak.R;


public class ProgressFragment extends Fragment{

    private FragmentListener listener;
    private DatabaseReference db;
    private Individual indiv;
    private String key;

    private BarChart chart ;
    private ArrayList<BarEntry> BARENTRY ;
    private ArrayList<String> BarEntryLabels ;
    private BarDataSet Bardataset ;
    private BarData BARDATA ;

    public ProgressFragment(){this.listener=null;key="";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_progress, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        db = FirebaseDatabase.getInstance().getReference().child("individuals");
        /*chart = (BarChart)view.findViewById(R.id.chart);
        chart.setNoDataText("");
        chart.setDescription("");*/

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                indiv = dataSnapshot.child(key).getValue(Individual.class);

                /*Map<String,Integer>skills;

                skills = indiv.getSkills();


                BARENTRY = new ArrayList<>();

                BarEntryLabels = new ArrayList<>();

                AddValuesToBARENTRY(skills.get("interpersonal"),skills.get("intrapersonal"));

                AddValuesToBarEntryLabels();

                Bardataset = new BarDataSet(BARENTRY, "Skills");

                BARDATA = new BarData(BarEntryLabels, Bardataset);


                Bardataset.setColors(ColorTemplate.VORDIPLOM_COLORS);

                chart.setData(BARDATA);

                chart.animateY(3000);*/

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

    /*public void AddValuesToBARENTRY(int skill_1,int skill_2) {

        BARENTRY.add(new BarEntry(skill_1,0));
        BARENTRY.add(new BarEntry(skill_2,1));

    }

    public void AddValuesToBarEntryLabels() {
        BarEntryLabels.add("Interpersonal");
        BarEntryLabels.add("Intrapersonal");
    }*/

    public interface FragmentListener
    {

    }
}
