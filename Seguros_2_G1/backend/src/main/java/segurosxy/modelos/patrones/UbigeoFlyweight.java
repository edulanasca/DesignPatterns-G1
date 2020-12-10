package segurosxy.modelos.patrones;

public class UbigeoFlyweight {

    private String departamento;
    private String provincia;
    private String distrito;

    public UbigeoFlyweight(String departamento, String provincia, String distrito)  {

        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

}
