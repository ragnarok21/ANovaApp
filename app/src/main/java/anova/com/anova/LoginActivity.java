package anova.com.anova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import anova.com.anova.session.SessionManager;

public class LoginActivity extends AppCompatActivity {

    LoginActivity loginActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SessionManager sessionManager = new SessionManager(this);
        final TextView username = (TextView)findViewById(R.id.username);
        final TextView password = (TextView)findViewById(R.id.password);
        Button login_button = (Button)findViewById(R.id.login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                sessionManager.createLoginSession(user,pass);
                Intent intent = new Intent(loginActivity,IndexActivity.class);
                startActivity(intent);
            }
        });
    }
}
