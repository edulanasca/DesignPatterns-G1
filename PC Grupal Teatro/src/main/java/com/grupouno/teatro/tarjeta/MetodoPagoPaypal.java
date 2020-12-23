package com.grupouno.teatro.tarjeta;

public class MetodoPagoPaypal implements MetodoPago {

  @Override
  public String pagar(Double monto) {
    return "Pagado " + ((obtenerImpuesto() + 1) * monto) + " con Paypal.";
  }

  @Override
  public double obtenerImpuesto() {
    return 0.30;
  }
}
