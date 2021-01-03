package tienda.controllers.impl;

import tienda.config.Paths;
import tienda.controllers.CustomerController;
import tienda.models.Cliente;
import tienda.models.patterns.state.cliente.ClienteCreado;
import tienda.models.patterns.state.cliente.ClienteDesactivo;
import tienda.repositories.ClienteRepositorio;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;


public class CustomerControllerImpl implements CustomerController {
    private static final String ID = "id";

    private final ClienteRepositorio customerRepository;

    public CustomerControllerImpl(ClienteRepositorio postRepository) {
        this.customerRepository = postRepository;
    }

    @Override
    public void create(Context context) {

        Cliente customer = context.bodyAsClass(Cliente.class);
        System.out.println("Cliente: " + customer);

        customer.setEstadoCliente(new ClienteCreado());
        customer.verificarDatos();

        customerRepository.create(customer);
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatClientLocation(customer.getId()));

    }

    @Override
    public void delete(Context context) {
        customerRepository.delete(context.pathParam(ID));

    }

    @Override
    public void find(Context context) {
        String id = context.pathParam(ID);
        Cliente customer = customerRepository.find(id);

        if (customer == null) {
            throw new NotFoundResponse(String.format("A customer with id '%s' is not found", id));
        }

        context.json(customer);

    }

    @Override
    public void findAll(Context context) {
        context.json(customerRepository.findAll());
    }

    @Override
    public void update(Context context) {
        Cliente customer = context.bodyAsClass(Cliente.class);
        String id = context.pathParam(ID);

        Cliente bdClient = customerRepository.find(id);

        if (customer.getId() != null && !customer.getId().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        customer.setEstadoCliente(bdClient.getEstadoCliente());
        customer.verificarDatos();
        System.out.println(customer);

        if (bdClient.getEstadoCliente() instanceof ClienteDesactivo) {
            throw new BadRequestResponse("El cliente ha sido desactivado");
        }

        customerRepository.update(customer, id);

    }

}