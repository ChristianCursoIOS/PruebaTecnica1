package com.appscloud.pruebatecnica.model;

public class Dato {

    private final String auditoria;
    private final String fechaInicioPlan;
    private final String sucursal;

    public Dato(String auditoria, String fechaInicioPlan, String sucursal) {
        this.auditoria = auditoria;
        this.fechaInicioPlan = fechaInicioPlan;
        this.sucursal = sucursal;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public String getFechaInicioPlan() {
        return fechaInicioPlan;
    }

    public String getSucursal() {
        return sucursal;
    }

}
