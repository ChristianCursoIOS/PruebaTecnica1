package com.appscloud.pruebatecnica.model;

import androidx.annotation.Nullable;

import java.util.Objects;

public class Datos {

    private String id;
    private String auditoria;
    private String fecha;
    private String sucursal;

    public Datos(String id, String auditoria, String fecha, String sucursal) {
        this.id = id;
        this.auditoria = auditoria;
        this.fecha = fecha;
        this.sucursal = sucursal;
    }

    public Datos(String auditoria, String fecha, String sucursal) {
        this.auditoria = auditoria;
        this.fecha = fecha;
        this.sucursal = sucursal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    // comparar que todos los campos que tenemos sean iguales para los datos nuevos o viejos

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datos datos = (Datos) o;
        return id.equals(datos.id) && auditoria.equals(datos.auditoria) && fecha.equals(datos.fecha) && sucursal.equals(datos.sucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, auditoria, fecha, sucursal);
    }
}
