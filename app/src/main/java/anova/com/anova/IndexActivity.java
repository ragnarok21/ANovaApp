package anova.com.anova;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends AppCompatActivity {

    IndexActivity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button button = (Button) findViewById(R.id.button);
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
    }
}
