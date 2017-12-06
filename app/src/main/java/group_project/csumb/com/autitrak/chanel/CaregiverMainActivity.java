package group_project.csumb.com.autitrak.chanel;

import android.content.Intent;
import android.media.Image;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import group_project.csumb.com.autitrak.R;
import group_project.csumb.com.autitrak.chanel.Notifications.CaregiverNotificationsActivity;
import group_project.csumb.com.autitrak.chanel.Notifications.UnreadActivity;

public class CaregiverMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton progressBtn;
    ImageButton notifBtn;
    ImageButton settingsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.caregiver_main_toolbar);
        setSupportActionBar(toolbar);

        // TODO: switch between fragments (might need to go back to Navigation Drawer.. BOOHOO)
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.caregiver_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.caregiver_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // init ImageButtons
//        progressBtn = (ImageButton) findViewById(R.id.caregiver_progress_btn);
//        notifBtn = (ImageButton) findViewById(R.id.caregiver_notif_btn);
//        settingsBtn = (ImageButton) findViewById(R.id.caregiver_settings_btn);

        // listener for progressBtn
//        progressBtn.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                setTitle("Progress");
//                ProgressFragment pf = new ProgressFragment();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.beginTransaction().replace(R.id.caregiver_fragment, pf).addToBackStack(null).commit();
//            }
//        });

        // listener for notifBtn
//        notifBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setTitle("Notifications");
//                NotificationsFragment nf = new NotificationsFragment();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.beginTransaction().replace(R.id.caregiver_fragment, nf).addToBackStack(null).commit();
//            }
//        });

        // listener for settingsBtn
//        settingsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setTitle("Settings");
//                SettingsFragment sf = new SettingsFragment();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.beginTransaction().replace(R.id.caregiver_fragment, sf).addToBackStack(null).commit();
//            }
//        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.caregiver_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.caregiver_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Progress
        if (id == R.id.caregiver_nav_progress) {
            setTitle("Progress");
            ProgressFragment pf = new ProgressFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.caregiver_fragment, pf).commit();
        }

        // Notifications
        else if (id == R.id.caregiver_nav_notifications) {
            setTitle("Notifications");
            NotificationsFragment pf = new NotificationsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.caregiver_fragment, pf).commit();
        }

        // Account
        else if (id == R.id.caregiver_nav_account) {
            setTitle("Account");
            AccountFragment af = new AccountFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.caregiver_fragment, af).commit();
        }

        // Settings
        else if (id == R.id.caregiver_nav_settings) {
            setTitle("Settings");
            SettingsFragment sf = new SettingsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.caregiver_fragment, sf).commit();
        }

        // Help
        else if (id == R.id.caregiver_nav_help) {
            setTitle("Help");
            HelpFragment hf = new HelpFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.caregiver_fragment, hf).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.caregiver_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
