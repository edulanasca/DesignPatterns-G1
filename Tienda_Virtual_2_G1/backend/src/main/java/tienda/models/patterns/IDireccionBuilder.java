package tienda.models.patterns;

import tienda.models.Direccion;

public interface IDireccionBuilder {

    IDireccionBuilder withResidencial(int numeroInterior, String nombreEdificio, String nombreConjuntoResidencial);

    IDireccionBuilder withCalle(String tipoCalle, String nombreCalle, int numeroPuerta);

    IDireccionBuilder withManzana(String manzana, int lote, String conjuntoVivienda);

    Direccion build();
}
