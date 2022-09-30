package com.nagv.ejemplosqlite.entidades;

public class tb_producto {

    private Integer codigoProducto;
    private String descripcion;
    private double precio;

    public tb_producto() {
    }

    public tb_producto(Integer codigoProducto, String descripcion, double precio) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
