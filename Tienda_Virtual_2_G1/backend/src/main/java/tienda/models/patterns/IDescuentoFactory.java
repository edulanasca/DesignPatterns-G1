package tienda.models.patterns;


public interface IDescuentoFactory {
    
    IDescuento crearDescuento( String tipoDescuento );
}