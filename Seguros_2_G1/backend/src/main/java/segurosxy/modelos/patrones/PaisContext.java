package segurosxy.modelos.patrones;

public class PaisContext {
    private String codPais;
    private String nomPais;
    private String codMarcPais;
    private PaisFlyweight pais;

    //Codigo del pais a 2 letras en mayuscula
    public PaisContext(String codPais ) {
        this.codPais = codPais;
        this.pais = PaisFactory.getInstance().getPais(codPais);
        this.nomPais = this.pais.getNomPais();
        this.codMarcPais = this.pais.getCodMarcacion();
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public PaisFlyweight getPais() {
        return pais;
    }

    public void setPais(PaisFlyweight pais) {
        this.pais = pais;
    }

    public String getCodMarcPais() {
        return codMarcPais;
    }

    public void setCodMarcPais(String codMarcPais) {
        this.codMarcPais = codMarcPais;
    }
}