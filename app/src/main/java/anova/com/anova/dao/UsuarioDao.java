package anova.com.anova.dao;

import anova.com.anova.domain.Usuario;

public interface UsuarioDao {

    void crearUsuario(String nombre, String apellido, String email, String contraseña);
    void eliminarUsuario(Long id);
    Usuario obtenerUsuario(String email);
    void open();
    void close();
}
