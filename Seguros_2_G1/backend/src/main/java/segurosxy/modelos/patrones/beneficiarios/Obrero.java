package segurosxy.modelos.patrones.beneficiarios;

public class Obrero extends Beneficiario{


    public Obrero(String nombre) {
        super(nombre);
    }

    @Override
    public void darDeAlta() {
        System.out.println("[Beneficiario Obrero] dando de ALTA a "+ nombre);
    }

    @Override
    public void darDeBaja() {
        System.out.println("[Beneficiario Obrero] dando de BAJA a "+nombre);
    }

    @Override
    public void suspension() {
        System.out.println("[Beneficiario Obrero] suspendiendo a "+nombre);
    }
}
