package com.tap.gestiontorneo.Model;
import com.tap.gestiontorneo.Model.Strategy.GeneracionCalendariosStrategy;

import java.util.List;

public class Torneo {
    private String nombre;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    // La referencia a la Estrategia
    private GeneracionCalendariosStrategy estrategiaCalendario;

    public Torneo(String nombre, List<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    // Inyección de la estrategia
    public void setEstrategiaCalendario(GeneracionCalendariosStrategy estrategia) {
        this.estrategiaCalendario = estrategia;
    }

    // Metodo que ejecuta la estrategia
    public void generarPartidos() {
        if (estrategiaCalendario == null) {
            throw new IllegalStateException("Debes definir una estrategia de calendario primero.");
        }
        this.partidos = estrategiaCalendario.generarCalendario(this.equipos);
    }

    public List<Partido> getPartidos() { return partidos; }
}
