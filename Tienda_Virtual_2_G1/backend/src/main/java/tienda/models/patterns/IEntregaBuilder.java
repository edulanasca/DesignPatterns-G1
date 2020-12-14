package tienda.models.patterns;

import tienda.models.Entrega;

public interface IEntregaBuilder {

    IEntregaBuilder withDatosContacto(String nombrePersona, String telefonoPersona);

    IEntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario);

    IEntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario);

    IEntregaBuilder withPersonalPropio(String personalPropio);

    Entrega build();
}