package tienda.models.patterns;

import tienda.models.DescuentoAniversario;
import tienda.models.DescuentoCupon;

public class DescuentoFactory implements IDescuentoFactory  {
    private DescuentoFactory (){ }
    private static DescuentoFactory descuentoIns;
    public static final String DESCUENTO_CUPON = "Cupon";
    public static final String DESCUENTO_ANIVERSARIO = "Aniversario";

    public static DescuentoFactory getInstance(){
        if (descuentoIns==null){
            descuentoIns=new DescuentoFactory(); }
            return descuentoIns;
        }


    public IDescuento crearDescuento(String tipoDescuento)   {

        if (tipoDescuento.equals(DESCUENTO_CUPON))  {

            return new DescuentoCupon();
        }
        if (tipoDescuento.equals(DESCUENTO_ANIVERSARIO))  {

            return new DescuentoAniversario();
        }        
        else {

            return null;
        }
    }
}