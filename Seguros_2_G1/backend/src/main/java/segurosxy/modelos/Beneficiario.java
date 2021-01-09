package segurosxy.modelos;

public class Beneficiario {

    private String nombre;

    public Beneficiario(String nombre){
        this.nombre = nombre;
    }

    public void darDeAlta(){
        System.out.println("[Beneficiario] dando de ALTA a "+nombre);
    }

    public void darDeBaja(){
        System.out.println("[Beneficiario] dando de BAJA a "+nombre);
    }

}
