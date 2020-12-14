package tienda.models;

import tienda.models.patterns.EntregaHogarBuilder;
import tienda.models.patterns.EntregaTiendaBuilder;
import tienda.models.patterns.EntregaBuilder;

public class Director {
    private EntregaBuilder entregaBuilder;

    public void setEntregaBuilder(EntregaBuilder builder) {
       entregaBuilder = builder;
    }

    public Entrega getTipoEntrega() {
        return entregaBuilder.getEntrega();
    }

    public Director (EntregaBuilder builder, String idOrder) {
        this.entregaBuilder = builder;

    }

    public Director withDatosContacto(String nombre, String telefono) {
        this.entregaBuilder.withDatosContacto(nombre, telefono);
        return this;
    }

    public Director withPersonalPropio(String personalPropio) {
        this.entregaBuilder.withPersonalPropio(personalPropio);
        return this;
    }

    public Director withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horairo) {
        this.entregaBuilder.withEntregaDomicilio(direccionEntrega, fechaEntrega, horairo);
        return this;
    }

    public Director withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario) {
        this.entregaBuilder.withEntregaDomicilio(tiendaRecojo, fechaRecojo, horario);
        return this;
    }



    public EntregaHogarBuilder constructorEntregaHogar() {
        entregaBuilder.createEntrega();
        entregaBuilder.withDatosContacto("josue","992001121").
                withPersonalPropio("algun personal").withEntregaDomicilio("direccion","fecha","horario");
        return null;
    }


}
