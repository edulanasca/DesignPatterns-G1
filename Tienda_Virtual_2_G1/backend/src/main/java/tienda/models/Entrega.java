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

    public Entrega() {

    }

    public Entrega(String idOrder, String nombrePersona, String telefonoPersona, String direccionEntrega, String fechaEntrega, String horario,
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
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFechaRecojo() {
        return fechaRecojo;
    }

    public void setFechaRecojo(String fechaRecojo) {
        this.fechaRecojo = fechaRecojo;
    }

    public String getTiendaRecojo() {
        return tiendaRecojo;
    }

    public void setTiendaRecojo(String tiendaRecojo) {
        this.tiendaRecojo = tiendaRecojo;
    }


    public String getPersonalPropio() {
        return personalPropio;
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

