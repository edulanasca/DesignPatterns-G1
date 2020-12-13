package segurosxy.seguro;

public class SeguroToByteAdapter {

  private final Seguro seguro;

  public SeguroToByteAdapter(Seguro seguro) {
    this.seguro = seguro;
  }

  public Seguro getSeguro() {
    return seguro;
  }

  public byte[] infoSeguroByte() {
    return seguro.infoSeguroCsv().getBytes();
  }

}
