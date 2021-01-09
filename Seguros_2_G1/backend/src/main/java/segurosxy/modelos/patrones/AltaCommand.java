package segurosxy.modelos.patrones;


import segurosxy.modelos.Beneficiario;

public class AltaCommand implements ICommand {

    @Override
    public void ejecutar(Beneficiario beneficiario) {
        System.out.println("[AltaCommand] usando beneficiario");
        beneficiario.darDeAlta();
    }
}
