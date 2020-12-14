package segurosxy.modelos.patrones;

public class PaisFlyweight {
    private String codPais;
    private String nomPais;
    private String codMarcacion;

    public PaisFlyweight(String codPais, String nomPais, String codMarcacion) {
        this.codPais = codPais;
        this.nomPais = nomPais;
        this.codMarcacion = codMarcacion;
    }

    public String getCodPais() {return codPais;}

    public void setCodPais(String codPais) {this.codPais = codPais;}

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public String getCodMarcacion() {
        return codMarcacion;
    }

    public void setCodMarcacion(String codMarcacion) {
        this.codMarcacion = codMarcacion;
    }
}