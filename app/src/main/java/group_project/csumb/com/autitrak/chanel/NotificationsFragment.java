package group_project.csumb.com.autitrak.chanel;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;

import group_project.csumb.com.autitrak.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {

    RecyclerView recyclerView;
    NotificationAdapter adapter;
    List<Notification> notifList;

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.caregiver_fragment_notifications, container, false);

        notifList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.caregiver_notif_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        // mock Notifications for now

        // unread
        notifList.add(
                new Notification("Demo Notification Subject",
                        "cst438@csumb.edu",
                        "caregiver@demo.com",
                        "This is a mock notification to test the Caregiver Notifications screen on AutiTrak.",
                        "Dec. 5, 2017",
                        0));

        // read
        notifList.add(
                new Notification("Welcome to AutiTrak!",
                        "autitrak@demo.com",
                        "caregiver@demo.com",
                        "Greetings Caregiver, We're happy to see you joining our community of...",
                        "Nov. 21, 2017",
                        1));

        // sent
        notifList.add(
                new Notification("Unable to Add Tasks",
                        "caregiver@demo.com",
                        "autitrak@demo.com",
                        "Hello AutiTrak team! I am trying to add tasks for my child but my list is not updating.",
                        "Oct. 8, 2017",
                        2));

        adapter = new NotificationAdapter(this.getActivity(), notifList);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
