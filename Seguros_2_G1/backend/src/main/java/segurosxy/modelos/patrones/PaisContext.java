package segurosxy.modelos.patrones;

public class PaisContext {
    private String codPais;
    private String descPais;

    public PaisContext(String codPais) {
        this.codPais = codPais;
        this.descPais = PaisFactory.getInstance().getPais(codPais).getDescPais();
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getDescPais() {
        return descPais;
    }

    public void setDescPais(String descPais) {
        this.descPais = descPais;
    }
}