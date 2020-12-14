package tienda.models.patterns;

import tienda.models.Entrega;

public class EntregaTiendaBuilder implements IEntregaBuilder{

    private String idOrder;
    private String telefonoPersona;
    private String nombrePersona;
    private String horario;
    private String fechaRecojo;
    private String tiendaRecojo;
    private String personalPropio;

    public EntregaTiendaBuilder( String idOrder )    {
        this.idOrder = idOrder;
    }


    public EntregaTiendaBuilder withDatosContacto(String nombrePersona, String telefonoPersona)  {
        this.nombrePersona = nombrePersona;
        this.telefonoPersona = telefonoPersona;
        return this;
    }

    //no se utiliza porque es entrega en tienda
    @Override
    public IEntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario) {
        return this;
    }

    public EntregaTiendaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario)  {
        this.tiendaRecojo = tiendaRecojo;
        this.fechaRecojo = fechaRecojo;
        this.horario = horario;
        return this;
    }

    public EntregaTiendaBuilder withPersonalPropio(String personalPropio)  {
        this.personalPropio = personalPropio;
        return this;
    }

    public Entrega build() {

        Entrega delivery = new Entrega();
        delivery.setNombrePersona(this.nombrePersona);
        delivery.setTelefonoPersona(this.telefonoPersona);
        delivery.setHorario(this.horario);
        delivery.setTiendaRecojo(this.tiendaRecojo);
        delivery.setFechaRecojo(this.fechaRecojo);
        delivery.setPersonalPropio(this.personalPropio);
        return delivery;
    }
}
