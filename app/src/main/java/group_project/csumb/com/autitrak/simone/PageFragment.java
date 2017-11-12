package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import group_project.csumb.com.autitrak.R;

/**
 * Created by sboyd on 11/9/2017.
 */

public class PageFragment extends Fragment{

    public PageFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_page, parent, false);
    }
}
