package tienda.models;

public class Producto {
    private String id;
    private String nombre;
    private Double price;
    //private Marca marc;
    //private Modelo model;

    public String imprimirProducto(){
        String producto="";
        producto =
        "ID: "+id+"\n"+
        "Nombre: "+nombre+"\n"+
        "Precio: "+price+"\n"
        //+"Marca: "+marc.printMarca()+"\n"
        //+"Modelo: "+model.printModel()+"\n"
        ;
        return producto;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }
}
