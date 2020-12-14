package tienda.models.patterns;

import tienda.models.Direccion;

public class DireccionCalleBuilder implements IDireccionBuilder {
    //formato direccion con calle
    private String tipoCalle;
    private String nombreCalle;
    private int numeroPuerta;

    //datos globales
    private String sector;
    private String grupo;
    private String distrito;

    public DireccionCalleBuilder() {

    }

    public DireccionCalleBuilder withCalle(String tipoCalle, String nombreCalle, int numeroPuerta) {
        this.tipoCalle = tipoCalle;
        this.nombreCalle = nombreCalle;
        this.numeroPuerta = numeroPuerta;
        return this;
    }

    //no se utiliza porque es direccion con calle
    public IDireccionBuilder withResidencial(int numeroInterior, String nombreEdificio, String nombreConjuntoResidencial) {
        return this;
    }

    //no se utiliza porque es direccion con calle
    public IDireccionBuilder withManzana(String manzana, int lote, String conjuntoVivienda) {
        return this;
    }

    public Direccion build() {
        Direccion direccion = new Direccion();
        direccion.setTipoCalle(this.tipoCalle);
        direccion.setNombreCalle(this.nombreCalle);
        direccion.setNumeroPuerta(this.numeroPuerta);
        direccion.setSector(this.sector);
        direccion.setGrupo(this.grupo);
        direccion.setDistrito(this.distrito);
        return direccion;
    }
}
