package segurosxy.modelos;

import lombok.AllArgsConstructor;
import segurosxy.modelos.interfaces.IPoliza;

@AllArgsConstructor
public class Poliza implements IPoliza {

    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String detallePoliza() {
        return "Poliza Base";
    }
}
