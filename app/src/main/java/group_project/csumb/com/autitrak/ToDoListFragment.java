package group_project.csumb.com.autitrak;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1, mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView todoListRecycler;
    ArrayList<ListItem> todoList;

    public ToDoListFragment() {
        // Required empty public constructor
    }

    public static ToDoListFragment newInstance(String param1, String param2) {
        ToDoListFragment fragment = new ToDoListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        todoList = new ArrayList<>();
        todoListRecycler = (RecyclerView)view.findViewById(R.id.recyclerId);
        todoListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fillList();
        ToDoListAdapter adapter = new ToDoListAdapter(todoList);
        todoListRecycler.setAdapter(adapter);
        return view;
    }

    public void fillList() {
        todoList.add(new ListItem("Brush Teeth", "Beginner","12/3/2017", "12/4/2017", 10));
        todoList.add(new ListItem("Sweep", "Beginner", "12/3/2017", "12/4/2017", 20));
        todoList.add(new ListItem("Pick Up Dog Poo", "Intermediate", "12/4/2017", "12/6/2017", 35));
        todoList.add(new ListItem("Eat All Your Veggies", "Intermediate", "12/3/2017", "12/3/2017", 10));
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
