package segurosxy.seguro;

import com.mongodb.BasicDBObject;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import segurosxy.modelos.Certificado;
import segurosxy.modelos.Poliza;
import segurosxy.modelos.interfaces.ICertificado;
import segurosxy.modelos.interfaces.IPoliza;

@ToString
public abstract class Seguro {

    protected ICertificado certificado;
    protected IPoliza poliza;
    protected String nivelRiesgo = "NINGUNO";

    public Seguro() {
        this.certificado = new Certificado();
    }

    public ICertificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public IPoliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public String getNivelRiesgo()  {
        return this.nivelRiesgo;
    }

    public abstract String detalleSeguro();

    public abstract void calcularRiesgo();
}
