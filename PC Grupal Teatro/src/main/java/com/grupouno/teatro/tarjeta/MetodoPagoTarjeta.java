package com.grupouno.teatro.tarjeta;

public class MetodoPagoTarjeta implements MetodoPago {

  @Override
  public String pagar(Double monto) {
    return "Pagado " + ((obtenerImpuesto() + 1) * monto) + " con tarjeta";
  }

  @Override
  public double obtenerImpuesto() {
    return 0.18;
  }
}
