package tienda.models.metodopago;

import com.fasterxml.uuid.Generators;
import tienda.models.Pedido;

import java.util.UUID;

public class BlockChainMetodoPago implements MetodoPago {

    private String walletId;

    public String getWalletId() {
        if(this.walletId == null){
            UUID uuid = Generators.timeBasedGenerator().generate();
            setWalletId(uuid.toString());
        }
        return walletId;
    }

    public void setWalletId(String walletId){
        this.walletId = walletId;
    }

    @Override
    public void pagarPedido(Pedido order){
        walletPayOrder(order);
    }

    @Override
    public double devolverComision(Double montoTotal) {
        return montoTotal * 0.05;
    }

    public void walletPayOrder(Pedido order){

        /* Doing Block Chain Validation */
        System.out.println("Procesando el pago con wallet " + walletId + " \n" +
            "Total: " + order.getMontoTotal() + " \n" +
            "Comision: " + this.devolverComision(order.getMontoTotal()));
    }
}
