package tienda.models;

import tienda.models.patterns.state.cliente.ClienteCreado;
import tienda.models.patterns.state.cliente.ClienteState;

import java.util.List;

public class Cliente {
    private String id;
    private String nombre;
    private List<Direccion> direcciones;
    private String numeroDocumento;
    private String correo;
    private ClienteState estadoCliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre)    {
        this.nombre = nombre;
    }

    public String getNombre()   {
        return this.nombre;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void setNumeroDocumento(String numeroDocumento)    {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento()   {
        return this.numeroDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ClienteState getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(ClienteState estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public void verificarDatos() {
        this.getEstadoCliente().verificarInfo(this);
    }
}

