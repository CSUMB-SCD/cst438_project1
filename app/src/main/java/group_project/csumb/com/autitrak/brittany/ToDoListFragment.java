package group_project.csumb.com.autitrak.brittany;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import group_project.csumb.com.autitrak.R;
import group_project.csumb.com.autitrak.simone.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1, mParam2;

    private OnFragmentInteractionListener mListener;

    private DatabaseReference db;
    private String key;

    RecyclerView todoListRecycler;
    List<ListItem> todoList;
    ToDoListAdapter adapter;
    List<Task>tasks;

    RelativeLayout rlayout;
    public ToDoListFragment() {
        // Required empty public constructor
    }



    //    public static ToDoListFragment newInstance(String param1, String param2) {
//        ToDoListFragment fragment = new ToDoListFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if(getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_individual_to_do_list, container, false);

        // TODO: figure out how to put bg img on to do list 
//        rlayout = (RelativeLayout) view.findViewById(R.id.to_do_list_rlayout);
//        rlayout.setBackground(getActivity().getResources().getDrawable(R.drawable.to_do_list_bg));

        todoList = new ArrayList<>();
        todoListRecycler = (RecyclerView)view.findViewById(R.id.recyclerId);
        todoListRecycler.setHasFixedSize(true);
        todoListRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        tasks = new ArrayList<>();
//


        db = FirebaseDatabase.getInstance().getReference().child("tasks").child(key);

//        Log.d("To Do List Size:", String.valueOf(todoList.size()));
        adapter = new ToDoListAdapter(todoList);
        todoListRecycler.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (long i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                    tasks.add(dataSnapshot.child(Long.toString(i + 1)).getValue(Task.class));
                }

                for(int i = 0; i < tasks.size();i++)
                {
                    todoList.add(new ListItem(tasks.get(i).getDescription(),tasks.get(i).getLevel(),tasks.get(i).getStartDate(),tasks.get(i).getEndDate(),tasks.get(i).getPoints(), R.drawable.puzzle));
                }


                adapter = new ToDoListAdapter(todoList);
                todoListRecycler.setAdapter(adapter);

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

    public void onButtonPressed(Uri uri) {
        if(mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
