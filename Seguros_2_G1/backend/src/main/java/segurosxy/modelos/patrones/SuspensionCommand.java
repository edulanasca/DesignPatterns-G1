package segurosxy.modelos.patrones;

import segurosxy.modelos.patrones.beneficiarios.Beneficiario;

public class SuspensionCommand implements ICommand{
    @Override
    public void ejecutar(Beneficiario beneficiario) {
        System.out.println("[SuspensionCommand] usando beneficiario");
        beneficiario.suspension();
    }
}
