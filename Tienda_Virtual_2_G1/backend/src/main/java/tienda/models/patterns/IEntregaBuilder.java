package tienda.models.patterns;

import tienda.models.Entrega;

public interface IEntregaBuilder {

    EntregaBuilder withDatosContacto(String nombrePersona, String telefonoPersona);

    EntregaBuilder withEntregaDomicilio(String direccionEntrega, String fechaEntrega, String horario);

    EntregaBuilder withRecojoEnTienda(String tiendaRecojo, String fechaRecojo, String horario);

    EntregaBuilder withPersonalPropio(String personalPropio);

    Entrega build();
}