package group_project.csumb.com.autitrak;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("message");

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myRef.setValue("Hello, World!");

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.caregiverDrawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.caregiverDrawerLayout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        int view = item.getItemId();
//        Log.d("ITEM ID: ", String.valueOf(view));
//
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_progress:
                setTitle("Progress");
                ProgressFragment pfrag = new ProgressFragment();
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.content_frame, pfrag).commit();
                break;

            case R.id.nav_notifications:
                setTitle("Notifications");
                NotificationsFragment nfrag = new NotificationsFragment();
                FragmentManager fm2 = getFragmentManager();
                fm2.beginTransaction().replace(R.id.content_frame, nfrag).commit();
                break;

            case R.id.nav_settings:
                setTitle("Settings");
                NotificationsFragment sfrag = new NotificationsFragment();
                FragmentManager fm3 = getFragmentManager();
                fm3.beginTransaction().replace(R.id.content_frame, sfrag).commit();
                break;

        }   // end switch(viewId)

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.caregiverDrawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
