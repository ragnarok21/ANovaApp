package anova.com.anova.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySqlLiteHelper extends SQLiteOpenHelper{

    public static final String TABLA_USUARIOS = "usuarios";
    public static final String COLUMNA_ID = "id";
    public static final String COLUMNA_NOMBRE = "nombre";
    public static final String COLUMNA_APELLIDO = "apellido";
    public static final String COLUMNA_EMAIL = "email";
    public static final String COLUMNA_CONTRASEÑA = "contraseña";

    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLA_USUARIOS + "( " + COLUMNA_ID
            + " integer primary key autoincrement, " + COLUMNA_NOMBRE
            + " text not null, " + COLUMNA_APELLIDO
            + " text not null, " + COLUMNA_EMAIL
            + " text not null, " + COLUMNA_CONTRASEÑA
            + " text not null);";

    public MySqlLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySqlLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIOS);
        onCreate(db);
    }
}
