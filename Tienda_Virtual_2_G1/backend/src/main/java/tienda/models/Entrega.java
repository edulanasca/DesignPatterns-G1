package tienda.models;

public class Entrega {

    private String idOrder;
    private String telefonoPersona;
    private String nombrePersona;
    private String direccionEntrega;
    private String fechaEntrega;
    private String horario;
    private String fechaRecojo;
    private String tiendaRecojo;
    private String personalPropio;

    /*public Entrega(String idOrder, String nombrePersona, String telefonoPersona, String direccionEntrega, String fechaEntrega, String horario,
                   String tiendaRecojo, String fechaRecojo, String personalPropio)    {

        this.idOrder = idOrder;
        this.nombrePersona = nombrePersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionEntrega = direccionEntrega;
        this.fechaEntrega = fechaEntrega;
        this.horario = horario;
        this.tiendaRecojo = tiendaRecojo;
        this.fechaRecojo = fechaRecojo;
        this.personalPropio = personalPropio;
    }*/

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setFechaRecojo(String fechaRecojo) {
        this.fechaRecojo = fechaRecojo;
    }

    public void setTiendaRecojo(String tiendaRecojo) {
        this.tiendaRecojo = tiendaRecojo;
    }

    public void setPersonalPropio(String personalPropio) {
        this.personalPropio = personalPropio;
    }

    @Override
    public String toString() {
        
        return idOrder + "-" + nombrePersona + "-" +  telefonoPersona
                       + (direccionEntrega!=null?"-" +  direccionEntrega + "-" + fechaEntrega:"") 
                       + (tiendaRecojo!=null?"-" +  tiendaRecojo + "-" +  fechaRecojo:"") 
                       + "-" + horario + "-" + personalPropio;
    }

}

