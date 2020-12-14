package tienda.models.patterns;

import tienda.models.Entrega;

public class EntregaHogarBuilder extends EntregaBuilder{

    private String idOrder;
    private String telefonoPersona;
    private String nombrePersona;
    private String direccionEntrega;
    private String fechaEntrega;
    private String horario;
    private String personalPropio;

    public EntregaHogarBuilder( String idOrder )    {
        this.idOrder = idOrder;
    }


    public EntregaHogarBuilder withDatosContacto(String nombrePersona, String telefonoPersona)  {
        this.nombrePersona = nombrePersona;
        this.telefonoPersona = telefonoPersona;
        return this;
    }

    public EntregaHogarBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario)  {
        this.direccionEntrega = direccionEntrega;
        this.fechaEntrega = fechaEntrega;
        this.horario = horario;
        return this;
    }

    //no se utiliza porque es entrea en hogar
    @Override
    public EntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario) {
        return this;
    }

    public EntregaHogarBuilder withPersonalPropio(String personalPropio)  {
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
        delivery.setPersonalPropio(this.personalPropio);
        return delivery;
    }
}
