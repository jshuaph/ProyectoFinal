package com.tap.gestiontorneo.Model.Strategy;

import com.tap.gestiontorneo.Model.Equipo;
import com.tap.gestiontorneo.Model.Partido;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class CalendarioEliminatoriaStrategy implements GeneracionCalendariosStrategy {
    @Override
    public List<Partido> generarCalendario(List<Equipo> equipos) {
        List<Partido> calendario = new ArrayList<>();

        // Validación básica
        if (equipos.size() % 2 != 0) {
            System.out.println("Advertencia: Número impar de equipos, uno quedará libre.");
        }

        int jornada = 1; // Solo hay jornada 1 (o Octavos/Cuartos)
        for (int i = 0; i < equipos.size() - 1; i += 2) {
            Partido partido = new Partido(
                    0,
                    equipos.get(i),
                    equipos.get(i+1),
                    LocalDateTime.now().plusDays(7),
                    jornada
            );
            calendario.add(partido);
        }
        System.out.println("Calendario de Eliminatoria generado: " + calendario.size() + " partidos.");
        return calendario;
    }
}