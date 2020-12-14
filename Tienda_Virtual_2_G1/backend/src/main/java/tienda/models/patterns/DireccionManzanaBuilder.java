package tienda.models.patterns;

import tienda.models.Direccion;

public class DireccionManzanaBuilder implements IDireccionBuilder{
    //formato direccion con manzana
    private String manzana;
    private int lote;
    private String conjuntoVivienda;

    //datos globales
    private String sector;
    private String grupo;
    private String distrito;

    public DireccionManzanaBuilder() {

    }

    public DireccionManzanaBuilder withManzana(String manzana, int lote, String conjuntoVivienda) {
        this.manzana = manzana;
        this.lote = lote;
        this.conjuntoVivienda = conjuntoVivienda;
        return this;
    }

    //no se utiliza porque es direccion con manzana
    public IDireccionBuilder withResidencial(int numeroInterior, String nombreEdificio, String nombreConjuntoResidencial) {
        return this;
    }

    //no se utiliza porque es direccion con manzana
    public IDireccionBuilder withCalle(String tipoCalle, String nombreCalle, int numeroPuerta) {
        return this;
    }

    public Direccion build() {
        Direccion direccion = new Direccion();
        direccion.setManzana(this.manzana);
        direccion.setLote(this.lote);
        direccion.setConjuntoVivienda(this.conjuntoVivienda);
        direccion.setSector(this.sector);
        direccion.setGrupo(this.grupo);
        direccion.setDistrito(this.distrito);
        return direccion;
    }
}
