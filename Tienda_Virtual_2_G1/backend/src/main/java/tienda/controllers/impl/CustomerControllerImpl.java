package tienda.controllers.impl;

import tienda.config.Paths;
//import tienda.config.Paths;
import tienda.controllers.CustomerController;
import tienda.models.Cliente;
import tienda.repositories.ClienteRepositorio;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
//import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;


public class CustomerControllerImpl implements CustomerController {
    private static final String ID = "id";

    private ClienteRepositorio customerRepository;

    public CustomerControllerImpl(ClienteRepositorio postRepository) {
        this.customerRepository = postRepository;
    }

    @Override
    public void create(Context context) {

        Cliente customer = context.bodyAsClass(Cliente.class);
        System.out.println("Cliente: " + customer);

        //if (customer.getId() != null) {
        //    throw new BadRequestResponse(String.format("Unable to create a new post with existing id: %s", customer));
        //}

        customerRepository.create(customer);
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(customer.getId().toString()));

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

        if (customer.getId() != null && !customer.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        customerRepository.update(customer, id);

    }

}