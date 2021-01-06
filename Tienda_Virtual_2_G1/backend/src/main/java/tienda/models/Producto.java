package tienda.models;

import tienda.models.patterns.CaretakerPrecio;
import tienda.models.patterns.MementoPrecio;
import tienda.models.interfaces.Marca;
import tienda.models.interfaces.Modelo;

public class Producto {
    private String id;
    private String codigo;
    private String descripcion;
    private Double precioBase;
    private String lineaProducto;
    private String mantenimiento;

    //tipo de camara
    private String camaraFrontal;
    private String camaraTrasera;

    //tipo de Bateria
    private String bateria;

    private CaretakerPrecio caretakerPrecio = new CaretakerPrecio();

    public Producto() {
    }

    public Producto(String codigo, String descripcion, Double precioBase, String linea, String mantenimiento)   {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.lineaProducto = linea;
        this.mantenimiento = mantenimiento;
    }

    //constructor con los nuevos atributos de camara y bateria
    public Producto(String codigo, String descripcion, Double precioBase, String linea, String mantenimiento, String camaraFrontal, String camaraTrasera, String bateria) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.lineaProducto = linea;
        this.mantenimiento = mantenimiento;
        this.camaraFrontal = camaraFrontal;
        this.camaraTrasera = camaraTrasera;
        this.bateria = bateria;
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
        System.out.println("Estableciendo precio base en: " + this.precioBase);
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

    public MementoPrecio grabaPrecio() {
        System.out.println("Grabando en Memento Precio.");
        return new MementoPrecio(precioBase);
    }
    public void recuperaPrecio(MementoPrecio m) {
        precioBase = m.getPrecio();
        System.out.println("Recuperando desde Memento Precio: " + precioBase);
    }

    public CaretakerPrecio getCaretakerPrecio() {
        return caretakerPrecio;
    }

    //get an set de camara y bateria
    public String getCamaraFrontal() {return camaraFrontal;}

    public void setCamaraFrontal(String camaraFrontal) {this.camaraFrontal = camaraFrontal;}

    public String getCamaraTrasera() {return camaraTrasera;}

    public void setCamaraTrasera(String camaraTrasera) {this.camaraTrasera = camaraTrasera;}

    public String getBateria() {return bateria;}

    public void setBateria(String bateria) {this.bateria = bateria;}

    public void setCaretakerPrecio(CaretakerPrecio caretakerPrecio) {
        this.caretakerPrecio = caretakerPrecio;
    }
}
