package tienda.models;

public class Entrega {

    //en entrega domicilio y en tienda
    private String idOrder;
    private String telefonoPersona;
    private String nombrePersona;
    private String horario;
    private String personalPropio;

    //solo entrega domicilio
    private String direccionEntrega;
    private String fechaEntrega;

    //solo en tienda
    private String fechaRecojo;
    private String tiendaRecojo;



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

