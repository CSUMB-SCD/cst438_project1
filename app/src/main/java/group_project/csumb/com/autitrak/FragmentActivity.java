package group_project.csumb.com.autitrak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import group_project.csumb.com.autitrak.chanel.CaregiverMainActivity;
import group_project.csumb.com.autitrak.simone.LoginFragment;
import group_project.csumb.com.autitrak.simone.MainFragment;
import group_project.csumb.com.autitrak.simone.User;


public class FragmentActivity extends android.support.v4.app.FragmentActivity{

    private FragmentManager fm;
    private DatabaseReference db;
    private User user;
    private MainFragment mf;
    private LoginFragment lf;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_individual_container);

        //Check if frame layout exist
        if(findViewById(R.id.fragment_individual_container)!=null)
        {
            //????
            if(savedInstanceState!=null)
            {
                return;
            }


            //Start activity here
            fm = getSupportFragmentManager();

            mf = new MainFragment();
            lf = new LoginFragment();


            //Start MainFragment onCreateView method
            fm.beginTransaction().add(R.id.fragment_individual_container,mf).commit();


            //Attach listener
            mf.setOnClickListener(new MainFragment.FragmentListener(){
                @Override
                public void onClicked(View v)
                {
                    if(v.getId() == R.id.login_fragment_button)
                    {
                        fm.beginTransaction().replace(R.id.fragment_individual_container,lf).commit();
                    }
                    else if(v.getId() == R.id.signup_fragment_button)
                    {
                       fm.beginTransaction().replace(R.id.fragment_individual_container_signup, lf).commit();
                    }
                }
            });


            lf.setOnClickListener(new LoginFragment.FragmentListener(){

                //Callback created in LoginFragment class, passes bool to check if FirebaseAuth signin successful
                @Override
                public void onSuccess(boolean in,String key) {
                    final String user_key = key;
                    if(in)
                    {

                        db = FirebaseDatabase.getInstance().getReference().child("users");

                        db.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                    user = dataSnapshot.child(user_key).getValue(User.class);

                                    if(user.getType() == 0)
                                    {
                                        Toast.makeText(FragmentActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                                        //Chanel replace MainActivity.clas with your Activity here!!!
                                        intent = new Intent(FragmentActivity.this, CaregiverMainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(FragmentActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                                        bundle = new Bundle();
                                        bundle.putString("key",user_key);

                                        intent = new Intent(FragmentActivity.this, IndividualMain.class);
                                        intent.putExtras(bundle);

                                        startActivity(intent);
                                    }
                                }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                    else
                    {
                        Toast.makeText(FragmentActivity.this,"Login failed!",Toast.LENGTH_LONG).show();
                    }
                }
            });


        }
    }


}
