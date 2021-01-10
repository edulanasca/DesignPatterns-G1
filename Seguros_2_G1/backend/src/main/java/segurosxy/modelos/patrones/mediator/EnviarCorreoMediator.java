package segurosxy.modelos.patrones.mediator;

import segurosxy.cliente.model.ClienteAsegurado;
import segurosxy.seguro.vehiculo.model.SeguroChoque;
import segurosxy.seguro.vehiculo.model.SeguroSOAT;

import java.util.List;

public class EnviarCorreoMediator {
  public static void main(String[] args) {

    ICorredorMediator mediator = new DummyCorreoMediator();
    ClienteAsegurado cliente = new ClienteAsegurado("Luis", mediator);
    cliente.setSeguros(List.of(new SeguroChoque(), new SeguroSOAT()));
    cliente.enviaCorreo();

  }
}
