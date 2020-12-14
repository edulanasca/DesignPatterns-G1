package tienda.models.patterns;

import tienda.models.Entrega;

public abstract class EntregaBuilder{

    /*private String idOrder;
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
        return null;
    }

    public EntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario)  {
        return null;
    }

    public EntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario)  {
        return null;
    }

    public EntregaBuilder withPersonalPropio(String personalPropio)  {
        return null;
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
    }*/
    protected Entrega entrega;

    public Entrega getEntrega() {
        return entrega;
    }

    public void createEntrega() {
        entrega = new Entrega();
        System.out.println("entrega creada");
    }

   public abstract EntregaBuilder withDatosContacto(String nombrePersona, String telefonoPersona);

    public abstract EntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario);

    public abstract EntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario);

    public abstract EntregaBuilder withPersonalPropio(String personalPropio);

    public abstract Entrega build();


}
