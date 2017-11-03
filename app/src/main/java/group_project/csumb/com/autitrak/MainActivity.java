package group_project.csumb.com.autitrak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        login = (Button)findViewById(R.id.login_button);
        signup = (Button)findViewById(R.id.signup_button);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i;
        if(v.getId() == login.getId())
        {
            i = new Intent(this,LoginActivity.class);
            startActivity(i);
        }
        else if(v.getId() == signup.getId())
        {

        }
    }
}
