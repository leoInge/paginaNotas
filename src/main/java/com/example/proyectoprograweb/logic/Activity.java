package com.example.proyectoprograweb.logic;

import java.util.Date;

public class Activity {
  private String idActividad;
  private String tipoActividad;
  private String descripcionActividad;
  private String ponderado;
  private String fechaEntrega;
  private String calificacionActividad;
  private String idMateria;

    public Activity(String idActividad, String tipoActividad, String descripcionActividad, String ponderado, String fechaEntrega, String calificacionActividad, String idMateria) {
        this.idActividad = idActividad;
        this.tipoActividad = tipoActividad;
        this.descripcionActividad = descripcionActividad;
        this.ponderado = ponderado;
        this.fechaEntrega = fechaEntrega;
        this.calificacionActividad = calificacionActividad;
        this.idMateria = idMateria;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public String getPonderado() {
        return ponderado;
    }

    public void setPonderado(String ponderado) {
        this.ponderado = ponderado;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCalificacionActividad() {
        return calificacionActividad;
    }

    public void setCalificacionActividad(String calificacionActividad) {
        this.calificacionActividad = calificacionActividad;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }
}
