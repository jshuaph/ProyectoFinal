package com.tap.gestiontorneo.Model.Strategy;

import com.tap.gestiontorneo.Model.Partido;
import com.tap.gestiontorneo.Model.Equipo;
import java.util.List;

public interface GeneracionCalendariosStrategy {
    List<Partido> generarCalendario(List<Equipo> equipos);
}
