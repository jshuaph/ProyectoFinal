package com.tap.gestiontorneo.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements Repositorio<Usuario> {

    private Connection conexion;

    public UsuarioDAO() {
        this.conexion = ConexionDB.getInstance().getConnection();
    }

    // Registrar nuevo usuario
    @Override
    public void agregar(Usuario usuario) {
        // Encriptamos la contraseña antes de guardarla (RF02)
        String sql = "INSERT INTO usuarios (nombre_usuario, password, rol) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, PasswordHash.encriptarSHA1(usuario.getContrasena()));
            stmt.setString(3, usuario.getRol());
            stmt.executeUpdate();
            System.out.println("Usuario registrado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Este metodo verifica si el usuario y la contraseña coinciden
    public Usuario validarCredenciales(String nombreUser, String passTextoPlano) {
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND password = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreUser);
            // Comparamos el hash de la contraseña ingresada con el hash en la BD
            stmt.setString(2, PasswordHash.encriptarSHA1(passTextoPlano));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getString("nombre_usuario"),
                        rs.getString("password"),
                        rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getString("nombre_usuario"),
                        rs.getString("password"),
                        rs.getString("rol")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar datos
    @Override
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre_usuario = ?, rol = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getRol());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar usuario
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        // pendiente implementar
        return null;
    }
}
