package com.tap.gestiontorneo.Model;

import java.time.LocalDateTime;

public class Partido {
    private int id;
    private Equipo eqLocal;
    private Equipo eqVisita;
    private LocalDateTime fecha;
    private int jornada;

    private int golesLocal;
    private int golesVisita;
    private boolean estado; // true si el partido ha sido jugado, false si está pendiente

    public Partido(int id, Equipo eqLocal, Equipo eqVisita, LocalDateTime fecha, int jornada) {
        this.id = id;
        this.eqLocal = eqLocal;
        this.eqVisita = eqVisita;
        this.fecha = fecha;
        this.jornada = jornada;
    }

    public void registrarResultado(int golesLocal, int golesVisita) {
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo getEqLocal() {
        return eqLocal;
    }

    public void setEqLocal(Equipo eqLocal) {
        this.eqLocal = eqLocal;
    }

    public Equipo getEqVisita() {
        return eqVisita;
    }

    public void setEqVisita(Equipo eqVisita) {
        this.eqVisita = eqVisita;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(int golesVisita) {
        this.golesVisita = golesVisita;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
