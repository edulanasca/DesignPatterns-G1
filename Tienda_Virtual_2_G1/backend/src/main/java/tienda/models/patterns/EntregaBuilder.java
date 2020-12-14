package tienda.models.patterns;

import tienda.models.Entrega;

public abstract class EntregaBuilder {

   public abstract EntregaBuilder withDatosContacto(String nombrePersona, String telefonoPersona);

    public abstract EntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario);

    public abstract EntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario);

    public abstract EntregaBuilder withPersonalPropio(String personalPropio);

    public abstract Entrega build();


}
