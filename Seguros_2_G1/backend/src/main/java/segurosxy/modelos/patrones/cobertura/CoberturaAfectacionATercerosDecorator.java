package segurosxy.modelos.patrones.cobertura;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaAfectacionATercerosDecorator extends CoberturaDecorator{

  public CoberturaAfectacionATercerosDecorator(ICobertura cobertura) {
    super(cobertura);
  }

  @Override
  public String calculaCobertura() {
    return super.calculaCobertura() + "\n"
        + agregarAfectacionATerceros();
  }

  private String agregarAfectacionATerceros() {
    return "[Cobertura Afectacion Terceros] Daños a terceros por parte del vehiculo";
  }


}
