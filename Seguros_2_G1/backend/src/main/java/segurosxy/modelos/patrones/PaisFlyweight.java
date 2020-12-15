package segurosxy.modelos.patrones;

public class PaisFlyweight {
    private String descPais;

    public PaisFlyweight(String descPais) {
        this.descPais = descPais;
    }

    public String getDescPais() {return descPais;}

    public void setDescPais(String descPais) {this.descPais = descPais;}

}