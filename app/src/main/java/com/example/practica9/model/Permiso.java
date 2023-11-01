package com.example.practica9.model;

public class Permiso {

    private String permiso;
    private String descripcion;
    private String permisos;
    private boolean estado;

    public Permiso(String permiso, String descripcion, String permisos) {
        this.permiso = permiso;
        this.descripcion = descripcion;
        this.permisos = permisos;
        this.estado = false;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public void setEstado(boolean b) {
    }

    public boolean isEstado() {
        return estado;
    }
}





