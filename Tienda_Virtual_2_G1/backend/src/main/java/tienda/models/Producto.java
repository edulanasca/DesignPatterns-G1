package tienda.models;

import tienda.models.interfaces.Marca;
import tienda.models.interfaces.Modelo;

public class Producto {
    private String id;
    private String codigo;
    private String descripcion;
    private Double precioBase;
    private String lineaProducto;
    private String mantenimiento;

    public Producto()   {
    }

    public Producto(String codigo, String descripcion, Double precioBase, String linea, String mantenimiento)   {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.lineaProducto = linea;
        this.mantenimiento = mantenimiento;
    }

    public Producto(String id)   {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public String getLineaProducto() {
        return lineaProducto;
    }

    public void setLineaProducto(String lineaProducto) {
        this.lineaProducto = lineaProducto;
    }

    public String getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
