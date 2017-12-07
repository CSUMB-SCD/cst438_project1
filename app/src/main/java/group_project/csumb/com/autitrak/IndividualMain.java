package group_project.csumb.com.autitrak;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import group_project.csumb.com.autitrak.brittany.AchievementsFragment;
import group_project.csumb.com.autitrak.brittany.AuditorySkillFragment;
import group_project.csumb.com.autitrak.brittany.HighScoresFragment;
import group_project.csumb.com.autitrak.brittany.RewardsFragment;
import group_project.csumb.com.autitrak.brittany.ToDoListFragment;
import group_project.csumb.com.autitrak.brittany.TrophyFragment;
import group_project.csumb.com.autitrak.simone.ProgressFragment;
import group_project.csumb.com.autitrak.simone.VisualAssessmentMainFragment;

public class IndividualMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AuditorySkillFragment.OnFragmentInteractionListener, ToDoListFragment.OnFragmentInteractionListener, TrophyFragment.OnFragmentInteractionListener, AchievementsFragment.OnFragmentInteractionListener, HighScoresFragment.OnFragmentInteractionListener, RewardsFragment.OnFragmentInteractionListener {



    private VisualAssessmentMainFragment vf;
    private AchievementsFragment af;
    private ToDoListFragment tf;
    private ProgressFragment pf;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.individual_main, menu);
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
        tf = null;
        af = null;
        pf = null;
        vf = null;
        int id = item.getItemId();
        boolean fragmentSelected = false;

        if (id == R.id.nav_to_do_list) {
            setTitle("To Do List");
            tf = new ToDoListFragment();
            fragmentSelected = true;
        } else if (id == R.id.nav_achievements) {
            setTitle("Achievements");
            af = new AchievementsFragment();
            fragmentSelected = true;
        }
        else if(id == R.id.nav_progress)
        {
            setTitle("Progress");
            pf = new ProgressFragment();
            pf.setKey(getIntent().getExtras().getString("key"));
            fragmentSelected = true;
        }
        else if(id == R.id.v_assessment){
            setTitle("Visual Assessment");
            vf = new VisualAssessmentMainFragment();
            fragmentSelected = true;
        }

        //} else if (id == R.id.nav_share) {

        //} else if (id == R.id.nav_send) {

        //}

        if(fragmentSelected) {
            if(pf != null)
            {

                getSupportFragmentManager().beginTransaction().replace(R.id.content_individual_main,pf).commit();

            }
            else if(af != null)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_individual_main, af).commit();
            }
            else if(tf != null)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_individual_main, tf).commit();
            }
            else if(vf != null)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_individual_main,vf).commit();
            }


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(auth.getCurrentUser() != null)
        {
            auth.signOut();
        }
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
