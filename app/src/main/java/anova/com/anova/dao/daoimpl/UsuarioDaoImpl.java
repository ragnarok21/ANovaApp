package anova.com.anova.dao.daoimpl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import anova.com.anova.dao.UsuarioDao;
import anova.com.anova.database.MySqlLiteHelper;
import anova.com.anova.domain.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

    private SQLiteDatabase database;
    private MySqlLiteHelper dbHelper;
    private String[] columnas = { MySqlLiteHelper.COLUMNA_ID,
            MySqlLiteHelper.COLUMNA_NOMBRE, MySqlLiteHelper.COLUMNA_APELLIDO,
            MySqlLiteHelper.COLUMNA_EMAIL, MySqlLiteHelper.COLUMNA_CONTRASEÑA};


    public UsuarioDaoImpl(Context context) {
        dbHelper = new MySqlLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public void crearUsuario(String nombre, String apellido, String email, String contraseña) {
        ContentValues values = new ContentValues();
        values.put(MySqlLiteHelper.COLUMNA_NOMBRE, nombre);
        values.put(MySqlLiteHelper.COLUMNA_APELLIDO, apellido);
        values.put(MySqlLiteHelper.COLUMNA_EMAIL, email);
        values.put(MySqlLiteHelper.COLUMNA_CONTRASEÑA, contraseña);
        long insertId = database.insert(MySqlLiteHelper.TABLA_USUARIOS, null, values);
        Cursor cursor = database.query(MySqlLiteHelper.TABLA_USUARIOS,
                columnas, MySqlLiteHelper.COLUMNA_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();
    }

    private Usuario cursorToUser(Cursor cursor) {
        Usuario usuario = new Usuario();
        usuario.setId(cursor.getLong(0));
        usuario.setNombre(cursor.getString(1));
        usuario.setApellido(cursor.getString(2));
        usuario.setEmail(cursor.getString(3));
        usuario.setContraseña(cursor.getString(4));
        return usuario;
    }

    @Override
    public void eliminarUsuario(Long id) {
        System.out.println("Comment deleted with id: " + id);
        database.delete(MySqlLiteHelper.TABLA_USUARIOS, MySqlLiteHelper.COLUMNA_ID
                + " = " + id, null);
    }

    @Override
    public Usuario obtenerUsuario(String email) {

        String selectQuery = "SELECT * FROM usuarios WHERE email =?";
        Cursor cursor = database.rawQuery(selectQuery, new String[] {email});
        cursor.moveToFirst();
        Usuario usuario = null;
        try {
            usuario = cursorToUser(cursor);
            cursor.close();
        }catch (Exception e){
            Log.d("USER","Usuario null");
        }
        return usuario;

    }
}
