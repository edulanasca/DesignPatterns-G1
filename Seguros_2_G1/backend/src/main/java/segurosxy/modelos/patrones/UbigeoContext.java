package segurosxy.modelos.patrones;

public class UbigeoContext {
    
    private String codigoDepartamento;
    private String codigoProvincia;
    private String codigoDistrito;
    private String departamento;
    private String provincia;
    private String distrito;
    
    private UbigeoFlyweight flyweight;

    public UbigeoContext(String codigoDepartamento, String codigoProvincia, String codigoDistrito) {

        this.flyweight = UbigeoFactory.getInstance().getUbigeo( codigoDepartamento, codigoProvincia, codigoDistrito);

        this.departamento = this.flyweight.getDepartamento();
        this.provincia = this.flyweight.getProvincia();
        this.distrito = this.flyweight.getDistrito();
        
        this.codigoDepartamento = codigoDepartamento;
        this.codigoProvincia = codigoProvincia;
        this.codigoDistrito = codigoDistrito;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
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
