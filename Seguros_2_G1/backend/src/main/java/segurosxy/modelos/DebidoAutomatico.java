package segurosxy.modelos;

import segurosxy.modelos.interfaces.IFormaPagoDebitoAutomatico;

public class DebidoAutomatico implements IFormaPagoDebitoAutomatico {

    public void realizaDescuentoAutomaticoBanco() {

        System.out.println("Genera cargo en la cuenta de debito automatico");
    }

}
