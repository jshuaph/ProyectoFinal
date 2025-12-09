package com.tap.gestiontorneo.Model.Strategy;

import com.tap.gestiontorneo.Model.Equipo;
import com.tap.gestiontorneo.Model.Partido;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class CalendarioLigaStrategy implements GeneracionCalendariosStrategy {
    @Override
    public List<Partido> generarCalendario(List<Equipo> equipos) {
        List<Partido> calendario = new ArrayList<>();
        int numEquipos = equipos.size();

        // Algoritmo simple de "Todos contra Todos"
        int jornada = 1;
        for (int i = 0; i < numEquipos; i++) {
            for (int j = i + 1; j < numEquipos; j++) {
                // Creamos el partido (ID 0 temporal, se genera en BD)
                // Fecha temporal: La ponemos hoy + jornada semanas
                LocalDateTime fechaJuego = LocalDateTime.now().plusWeeks(jornada);

                Partido partido = new Partido(
                        0,
                        equipos.get(i),
                        equipos.get(j),
                        fechaJuego,
                        jornada
                );
                calendario.add(partido);
                jornada++;
            }
        }
        System.out.println("Calendario de Liga generado: " + calendario.size() + " partidos.");
        return calendario;
    }
}