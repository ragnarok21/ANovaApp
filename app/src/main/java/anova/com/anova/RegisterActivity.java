package anova.com.anova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import anova.com.anova.dao.UsuarioDao;
import anova.com.anova.dao.daoimpl.UsuarioDaoImpl;

public class RegisterActivity extends AppCompatActivity {

    RegisterActivity registerActivity = this;

    private UsuarioDao usuarioDao;

    private TextView nombre;
    private TextView apellido;
    private TextView correo;
    private TextView contraseña;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        correo = (TextView) findViewById(R.id.email);
        contraseña = (TextView) findViewById(R.id.password);
        registrar = (Button) findViewById(R.id.registrar);
        usuarioDao = new UsuarioDaoImpl(this);
        usuarioDao.open();
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nombre.getText().toString().trim();
                String lastname = apellido.getText().toString().trim();
                String email  = correo.getText().toString().trim();
                String password = contraseña.getText().toString().trim();
                usuarioDao.crearUsuario(name,lastname,email,password);
                Intent intent = new Intent(registerActivity,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
