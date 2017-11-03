package group_project.csumb.com.autitrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("message");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myRef.setValue("Hello, World!");
    }

    public void ChangeFragment(View view) {
        Fragment fragment;

        // notifications button clicked
        if (view == findViewById(R.id.notifications_button)) {
            fragment = new NotificationsFragment();

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.caregiver_fragment, fragment);
            ft.commit();

        }

        // progress button clicked
        else if (view == findViewById(R.id.progress_button)) {
            fragment = new ProgressFragment();

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.caregiver_fragment, fragment);
            ft.commit();
        }

        // settings button clicked
        else if(view == findViewById(R.id.settings_button)) {
            fragment = new SettingsFragment();

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.caregiver_fragment, fragment);
            ft.commit();
        }
    }
}
