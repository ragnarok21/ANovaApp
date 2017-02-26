package anova.com.anova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anova.com.anova.session.SessionManager;

public class MainActivity extends AppCompatActivity {

    MainActivity mainActivity = this;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager =  new SessionManager(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Thread thread = new Thread(){
            public void run(){
                try {
                    this.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
/*falta verificar conexion a internet y red wifi activada*/
                if(!sessionManager.isLoggedIn()){
                    Intent intent = new Intent(mainActivity,LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(mainActivity,IndexActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

}
