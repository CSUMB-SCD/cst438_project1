package group_project.csumb.com.autitrak.chanel.Notifications;

/**
 * Created by chanel on 12/3/17.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import group_project.csumb.com.autitrak.R;

public class UnreadActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.caregiver_notif_unread_fragment, container, false);
        return rootView;
    }

}
