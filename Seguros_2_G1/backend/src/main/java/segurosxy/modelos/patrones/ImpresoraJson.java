package segurosxy.modelos.patrones;

import segurosxy.modelos.Poliza;

public class ImpresoraJson {

    public static void imprimir( String cadena ) throws Exception {

        if (!cadena.startsWith("{")) {
            System.out.println("NO IMPRIME. No inicia con llaves");
            throw new Exception("NO IMPRIME. No inicia con llaves");
        }
        if (!cadena.endsWith("}")) {
            System.out.println("NO IMPRIME. No finaliza con llaves");
            throw new Exception("NO IMPRIME. No finaliza con llaves");
        }

        System.out.println("IMPRIMIENDO...");
        System.out.println( cadena );
        System.out.println();
    }

    //prueba de la impresora
    public static void main(String[] args) {
        Poliza p = new Poliza(123,"nombre1","nombre2");
        PolizaAdapter3 pn = new  PolizaAdapter3(p);
        try {
            imprimir(pn.armarSalidaTexto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
