package segurosxy.modelos.patrones;

import segurosxy.modelos.Beneficiario;

public interface ICommand {

    void ejecutar(Beneficiario beneficiario);

}
