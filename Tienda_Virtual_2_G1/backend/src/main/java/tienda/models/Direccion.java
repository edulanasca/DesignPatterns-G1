package tienda.models;

public class Direccion {
    //formato direccion con calle
    private String tipoCalle;
    private String nombreCalle;
    private int numeroPuerta;

    //formato direccion con manzana
    private String manzana;
    private int lote;
    private String conjuntoVivienda;

    //formato direccion con residencial
    private int numeroInterior;
    private String nombreEdificio;
    private String nombreConjuntoResidencial;

    //datos globales
    private String sector;
    private String grupo;
    private String distrito;

    public void setTipoCalle(String tipoCalle) {
        this.tipoCalle = tipoCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public void setNumeroPuerta(int numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public void setConjuntoVivienda(String conjuntoVivienda) {
        this.conjuntoVivienda = conjuntoVivienda;
    }

    public void setNumeroInterior(int númeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public void setNombreConjuntoResidencial(String nombreConjuntoResidencial) {
        this.nombreConjuntoResidencial = nombreConjuntoResidencial;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Direccion{" + "sector='" + sector + '-' + ", grupo='" + grupo + '-' + ", distrito='" + distrito + '-'
                + (nombreCalle!=null?"-" +  nombreCalle + "-" + tipoCalle + "-" + numeroPuerta:"")
                + (manzana!=null?"-" +  manzana + "-" + lote + "-" + conjuntoVivienda:"")
                + (nombreEdificio!=null?"-" +  numeroInterior + "-" + nombreEdificio + "-" + nombreConjuntoResidencial:"") +'}';
    }
}
