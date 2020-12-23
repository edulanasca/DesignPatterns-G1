package com.grupouno.teatro.tarjeta;

public interface MetodoPago {
  String pagar(Double monto);
  double obtenerImpuesto();
}
