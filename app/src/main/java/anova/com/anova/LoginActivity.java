package anova.com.anova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import anova.com.anova.dao.UsuarioDao;
import anova.com.anova.dao.daoimpl.UsuarioDaoImpl;
import anova.com.anova.domain.Usuario;
import anova.com.anova.session.SessionManager;

public class LoginActivity extends AppCompatActivity {

    LoginActivity loginActivity = this;
    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SessionManager sessionManager = new SessionManager(this);
        final TextView username = (TextView)findViewById(R.id.username);
        final TextView password = (TextView)findViewById(R.id.password);
        usuarioDao = new UsuarioDaoImpl(this);
        usuarioDao.open();
        Button login_button = (Button)findViewById(R.id.login);
        Button register_button = (Button)findViewById(R.id.registro);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                Usuario usuario = usuarioDao.obtenerUsuario(email);
                if(usuario != null){
                    sessionManager.createLoginSession(usuario);
                    Intent intent = new Intent(loginActivity,MenuUserActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(loginActivity, "Usuario no registrado", Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                }
            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
