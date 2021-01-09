package segurosxy.modelos.patrones;

public class Impresora {
    
    public static void imprimir( String cadena ) throws Exception {

        if (!cadena.startsWith("<")) {
            System.out.println("NO IMPRIME. No inicia con etiqueta XML"); 
            throw new Exception("NO IMPRIME. No inicia con etiqueta XML");
        }
        if (!cadena.endsWith(">")) {
            System.out.println("NO IMPRIME. No finaliza con etiqueta XML");
            throw new Exception("NO IMPRIME. No finaliza con etiqueta XML");
        }
        
        System.out.println("IMPRIMIENDO...");
        System.out.println( cadena );
        System.out.println();
    }
}
