package segurosxy.seguro;

import segurosxy.modelos.Certificado;
import segurosxy.modelos.Poliza;
import segurosxy.seguro.vehiculo.model.SeguroChoque;
import segurosxy.seguro.vehiculo.model.SeguroVehicular;

import java.util.Arrays;

public class Banco {
  public static void main(String[] args) {

    SeguroVehicular choque = new SeguroChoque("Toyota", "Yaris");
    choque.poliza = new Poliza();
    choque.certificado = new Certificado();

    SeguroToByteAdapter adapter = new SeguroToByteAdapter(choque);
    recibirDatos(adapter.infoSeguroByte());
  }

  public static void recibirDatos(byte[] dato) {
    System.out.println("Array de bytes recibidos: " + Arrays.toString(dato) + "\n");
    System.out.println("Mensaje decodificado: " + new String(dato));
  }
}
