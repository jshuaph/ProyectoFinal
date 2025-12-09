package com.tap.gestiontorneo.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO implements Repositorio<Equipo> {

    private Connection conexion;

    public EquipoDAO() {
        this.conexion = ConexionDB.getInstance().getConnection();
    }

    // --- CREATE: Registrar un nuevo equipo (RF03) ---
    @Override
    public void agregar(Equipo equipo) {
        String sql = "INSERT INTO equipos (nombre, ciudad, ruta_escudo) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCiudad());
            stmt.executeUpdate();
            System.out.println("Equipo guardado: " + equipo.getNombre());
        } catch (SQLException e) {
            System.err.println("Error al guardar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- READ: Listar todos los equipos (Orden por defecto ID) ---
    @Override
    public List<Equipo> obtenerTodos() {
        List<Equipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipos";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapResultSetToEquipo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Obtener Tabla de Posiciones
    public List<Equipo> listarTablaPosiciones() {
        List<Equipo> lista = new ArrayList<>();
        // Ordenamos por Puntos DESC, y si empatan, por Diferencia de Goles DESC
        String sql = "SELECT * FROM equipos ORDER BY puntos DESC, diferencia_goles DESC, goles_favor DESC";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapResultSetToEquipo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Buscar un equipo por ID
    @Override
    public Equipo obtenerPorId(int id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToEquipo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar datos de un equipo
    @Override
    public void actualizar(Equipo equipo) {
        String sql = "UPDATE equipos SET nombre=?, ciudad=?, ruta_escudo=?, " +
                "puntos=?, partidos_jugados=?, victorias=?, empates=?, derrotas=?, " +
                "goles_favor=?, goles_contra=?, diferencia_goles=? " +
                "WHERE id=?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCiudad());
            // Actualización de estadísticas
            stmt.setInt(3, equipo.getPuntos());
            stmt.setInt(4, equipo.getPartidosJugados());
            stmt.setInt(5, equipo.getVictorias());
            stmt.setInt(6, equipo.getEmpates());
            stmt.setInt(7, equipo.getDerrotas());
            stmt.setInt(8, equipo.getGolesAFavor());
            stmt.setInt(9, equipo.getGolesEnContra());
            stmt.setInt(10, equipo.getDiferenciaGoles());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Eliminar un equipo
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipos WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // mapear ResultSet a Objeto Equipo ---
    private Equipo mapResultSetToEquipo(ResultSet rs) throws SQLException {
        // Creamos el objeto con los datos básicos
        Equipo e = new Equipo(
                rs.getString("nombre"),
                rs.getString("ciudad")
        );

        // Asignamos las estadísticas desde la BD usando los setters
        e.setPuntos(rs.getInt("puntos"));
        e.setPartidosJugados(rs.getInt("partidos_jugados"));
        e.setVictorias(rs.getInt("victorias"));
        e.setEmpates(rs.getInt("empates"));
        e.setDerrotas(rs.getInt("derrotas"));
        e.setGolesAFavor(rs.getInt("goles_favor"));
        e.setGolesEnContra(rs.getInt("goles_contra"));

        return e;
    }
}