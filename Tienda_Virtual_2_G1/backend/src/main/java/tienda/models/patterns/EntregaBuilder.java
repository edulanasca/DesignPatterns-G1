package tienda.models.patterns;

import tienda.models.Entrega;

public class EntregaBuilder implements IEntregaBuilder {

    private String idOrder;
    private String telefonoPersona;
    private String nombrePersona;
    private String direccionEntrega;
    private String fechaEntrega;
    private String horario;
    private String fechaRecojo;
    private String tiendaRecojo;
    private String personalPropio;

    public EntregaBuilder( String idOrder )    {

        this.idOrder = idOrder;
    }

    public EntregaBuilder withDatosContacto(String nombrePersona, String telefonoPersona)  {
        this.nombrePersona = nombrePersona;
        this.telefonoPersona = telefonoPersona;
        return this;
    }

    public EntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario)  {
        this.direccionEntrega = direccionEntrega;
        this.fechaEntrega = fechaEntrega;
        this.horario = horario;
        return this;
    }

    public EntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario)  {
        this.tiendaRecojo = tiendaRecojo;
        this.fechaRecojo = fechaRecojo;
        this.horario = horario;
        return this;
    }

    public EntregaBuilder withPersonalPropio(String personalPropio)  {
        this.personalPropio = personalPropio;
        return this;
    }

    @Override
    public Entrega build() {

        Entrega delivery = new Entrega();        
        delivery.setIdOrder(this.idOrder);
        delivery.setNombrePersona(this.nombrePersona);
        delivery.setTelefonoPersona(this.telefonoPersona);
        delivery.setDireccionEntrega(this.direccionEntrega);
        delivery.setFechaEntrega(this.fechaEntrega);
        delivery.setHorario(this.horario);
        delivery.setTiendaRecojo(this.tiendaRecojo);
        delivery.setFechaRecojo(this.fechaRecojo);
        delivery.setPersonalPropio(this.personalPropio);
        return delivery;
    }
    
}
