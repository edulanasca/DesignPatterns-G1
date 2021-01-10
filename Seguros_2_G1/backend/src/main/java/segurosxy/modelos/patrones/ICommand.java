package segurosxy.modelos.patrones;

import segurosxy.modelos.patrones.beneficiarios.Beneficiario;

public interface ICommand {

    void ejecutar(Beneficiario beneficiario);

}
