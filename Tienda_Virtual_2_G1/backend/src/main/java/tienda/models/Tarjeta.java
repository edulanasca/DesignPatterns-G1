package tienda.models;

import java.time.LocalDate;

public class Tarjeta {
  private String numero;
  private LocalDate vencimiento;
  private char[] CVV;

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public LocalDate getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(LocalDate vencimiento) {
    this.vencimiento = vencimiento;
  }

  public char[] getCVV() {
    return CVV;
  }

  public void setCVV(char[] CVV) {
    this.CVV = CVV;
  }
}
