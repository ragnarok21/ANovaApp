package anova.com.anova;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import anova.com.anova.session.SessionManager;

public class IndexActivity extends AppCompatActivity {

    IndexActivity mainActivity = this;

    private TextView nombre;
    private TextView apellido;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button button = (Button) findViewById(R.id.button);
        Button cerrar_sesion = (Button) findViewById(R.id.cerrar_sesion);
        final SessionManager sessionManager = new SessionManager(this);
        HashMap<String,String> userdata = sessionManager.getUserDetails();
        nombre = (TextView)findViewById(R.id.nombreUsuario) ;
        apellido = (TextView)findViewById(R.id.apellidoUsuario) ;
        email = (TextView)findViewById(R.id.emailUsuario) ;
        nombre.setText(userdata.get("nombre"));
        apellido.setText(userdata.get("apellido"));
        email.setText(userdata.get("email"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(mainActivity);
                alert.setTitle("Pregunta para jose Miguel");
                alert.setMessage("¿Eres gay?");

                alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //Your action here
                    }
                });

                alert.setNegativeButton("Si", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton) {

                     }
                });

                alert.show();
            }
        });
        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutUser();
            }
        });
    }
}
