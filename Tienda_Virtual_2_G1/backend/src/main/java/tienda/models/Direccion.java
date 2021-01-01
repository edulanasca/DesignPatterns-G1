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

    public String getTipoCalle() {
        return tipoCalle;
    }

    public void setTipoCalle(String tipoCalle) {
        this.tipoCalle = tipoCalle;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getNumeroPuerta() {
        return numeroPuerta;
    }

    public void setNumeroPuerta(int numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getConjuntoVivienda() {
        return conjuntoVivienda;
    }

    public void setConjuntoVivienda(String conjuntoVivienda) {
        this.conjuntoVivienda = conjuntoVivienda;
    }

    public int getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(int numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getNombreConjuntoResidencial() {
        return nombreConjuntoResidencial;
    }

    public void setNombreConjuntoResidencial(String nombreConjuntoResidencial) {
        this.nombreConjuntoResidencial = nombreConjuntoResidencial;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDistrito() {
        return distrito;
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
