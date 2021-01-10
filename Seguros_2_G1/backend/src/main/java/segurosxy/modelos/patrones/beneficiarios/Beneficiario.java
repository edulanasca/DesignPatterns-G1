package segurosxy.modelos.patrones.beneficiarios;

public abstract class Beneficiario {

    protected String nombre;

    public Beneficiario(String nombre){
        this.nombre = nombre;
    }

    public abstract void darDeAlta();

    public abstract void darDeBaja();

    public abstract void suspension();

}
