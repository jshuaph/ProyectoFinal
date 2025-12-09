package com.tap.gestiontorneo.Model;

import com.tap.gestiontorneo.Model.Strategy.CalendarioEliminatoriaStrategy;
import com.tap.gestiontorneo.Model.Strategy.CalendarioLigaStrategy;

import java.util.List;

public class TorneoFactory {

    // Metodo Factory estático
    public static Torneo crearTorneo(String tipo, String nombre, List<Equipo> equipos) {
        Torneo torneo = new Torneo(nombre, equipos);

        switch (tipo.toLowerCase()) {
            case "liga":
                // Asigna la estrategia de Liga
                torneo.setEstrategiaCalendario(new CalendarioLigaStrategy());
                break;
            case "eliminatoria":
                // Asigna la estrategia de Eliminatoria
                torneo.setEstrategiaCalendario(new CalendarioEliminatoriaStrategy());
                break;

            default:
                throw new IllegalArgumentException("Tipo de torneo no válido: " + tipo);
        }

        return torneo;
    }
}