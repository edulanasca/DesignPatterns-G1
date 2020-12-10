package tienda.controllers.impl;

import org.jetbrains.annotations.NotNull;
import tienda.config.Paths;
import tienda.controllers.ProductController;
import tienda.models.Producto;
import tienda.models.patterns.GamaAltaFactory;
import tienda.models.patterns.GamaBajaFactory;
import tienda.models.patterns.IProductoFactory;
import tienda.repositories.ProductoRepositorio;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
//import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;


public class ProductControllerImpl implements ProductController {
    private static final String ID = "id";

    private final ProductoRepositorio productRepository;

    public ProductControllerImpl(ProductoRepositorio postRepository) {
        this.productRepository = postRepository;
    }

    @Override
    public void create(@NotNull Context context) {

        Producto Product = context.bodyAsClass(Producto.class);
        System.out.println("Producto: " + Product);

        //if (Product.getId() != null) {
        //    throw new BadRequestResponse(String.format("Unable to create a new post with existing id: %s", Product));
        //}

        productRepository.create(Product);
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(Product.getId()));

    }

    @Override
    public void delete(@NotNull Context context) {
        productRepository.delete(context.pathParam(ID));

    }

    @Override
    public void find(@NotNull Context context) {
        String id = context.pathParam(ID);
        Producto Product = productRepository.find(id);

        if (Product == null) {
            throw new NotFoundResponse(String.format("A Product with id '%s' is not found", id));
        }

        context.json(Product);

    }

    @Override
    public void findAll(@NotNull Context context) {
        context.json(productRepository.findAll());
    }

    @Override
    public void update(@NotNull Context context) {
        Producto product = context.bodyAsClass(Producto.class);
        String id = context.pathParam(ID);

        if (product.getId() != null && !product.getId().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        productRepository.update(product, id);

    }

    @Override
    public void loadProducts(@NotNull Context context) {

        IProductoFactory factoryProduct = new GamaAltaFactory();
        String lineaA = factoryProduct.getLineaProducto().getLinea();
        String mantenimientoA = factoryProduct.getMantenimiento().getPeriodo();

        factoryProduct = new GamaBajaFactory();
        String lineaB = factoryProduct.getLineaProducto().getLinea();
        String mantenimientoB = factoryProduct.getMantenimiento().getPeriodo();

        Producto pr1 = new Producto("P01010016","Samsung S10", 2500.00, lineaA, mantenimientoA);
        productRepository.create(pr1);
        Producto pr2 = new Producto("P01010017","Samsung A10", 1000.00, lineaB, mantenimientoB);
        productRepository.create(pr2);
        Producto pr3 = new Producto("P01010018","Samsung S20", 3000.00, lineaA, mantenimientoA);
        productRepository.create(pr3);
    }
    
}