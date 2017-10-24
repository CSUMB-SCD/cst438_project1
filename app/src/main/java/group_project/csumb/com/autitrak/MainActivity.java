package group_project.csumb.com.autitrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.database.DB.DB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        login = (Button)findViewById(R.id.menu_login_bttn);
        signup = (Button)findViewById(R.id.menu_signup_bttn);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId())
        {
            case R.id.menu_login_bttn:
                i = new Intent(this,LoginActivity.class);
                startActivity(i);
                break;


        }
    }
}
