package tienda.models;

import tienda.models.patterns.EntregaHogarBuilder;
import tienda.models.patterns.IEntregaBuilder;

public class EntregaBuilderDirector {
    private IEntregaBuilder entregaBuilder;

    public void setEntregaBuilder(IEntregaBuilder builder) {
       entregaBuilder = builder;
    }

    public EntregaBuilderDirector(IEntregaBuilder builder) {
        this.entregaBuilder = builder;
    }


    /*public EntregaBuilderDirector withDatosContacto(String nombre, String telefono) {
        this.entregaBuilder.withDatosContacto(nombre, telefono);
        return this;
    }

    public EntregaBuilderDirector withPersonalPropio(String personalPropio) {
        this.entregaBuilder.withPersonalPropio(personalPropio);
        return this;
    }

    public EntregaBuilderDirector withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horairo) {
        this.entregaBuilder.withEntregaDomicilio(direccionEntrega, fechaEntrega, horairo);
        return this;
    }

    public EntregaBuilderDirector withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario) {
        this.entregaBuilder.withEntregaDomicilio(tiendaRecojo, fechaRecojo, horario);
        return this;
    }*/

}
