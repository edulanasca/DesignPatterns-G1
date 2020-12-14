package tienda.models.patterns;

import tienda.models.Direccion;

public class DireccionResidencialBuilder implements IDireccionBuilder {

    //formato direccion con residencial
    private int numeroInterior;
    private String nombreEdificio;
    private String nombreConjuntoResidencial;

    //datos globales
    private String sector;
    private String grupo;
    private String distrito;

    public DireccionResidencialBuilder() {

    }

    public DireccionResidencialBuilder withResidencial(int numeroInterior, String nombreEdificio, String nombreConjuntoResidencial) {
        this.numeroInterior = numeroInterior;
        this.nombreEdificio = nombreEdificio;
        this.nombreConjuntoResidencial = nombreConjuntoResidencial;
        return this;
    }

    //no se utiliza porque es direccion con residencia
    public IDireccionBuilder withCalle(String tipoCalle, String nombreCalle, int numeroPuerta) {
        return this;
    }

    //no se utiliza porque es direccion con calle
    public IDireccionBuilder withManzana(String manzana, int lote, String conjuntoVivienda) {
        return this;
    }

    public Direccion build() {
        Direccion direccion = new Direccion();
        direccion.setNumeroInterior(this.numeroInterior);
        direccion.setNombreEdificio(this.nombreEdificio);
        direccion.setNombreConjuntoResidencial(this.nombreConjuntoResidencial);
        direccion.setSector(this.sector);
        direccion.setGrupo(this.grupo);
        direccion.setDistrito(this.distrito);
        return direccion;
    }
}
