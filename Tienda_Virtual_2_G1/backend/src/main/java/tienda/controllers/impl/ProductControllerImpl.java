package tienda.controllers.impl;

import org.jetbrains.annotations.NotNull;
import tienda.config.Paths;
import tienda.controllers.ProductController;
import tienda.models.Producto;
import tienda.models.patterns.GamaAltaFactory;
import tienda.models.patterns.GamaBajaFactory;
import tienda.models.patterns.GamaMediaFactory;
import tienda.models.patterns.IProductoFactory;
import tienda.repositories.ProductoRepositorio;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
//import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;

import java.util.HashMap;


public class ProductControllerImpl implements ProductController {
    private static final String ID = "id";

    private final ProductoRepositorio productRepository;

    public ProductControllerImpl(ProductoRepositorio postRepository) {
        this.productRepository = postRepository;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void create(@NotNull Context context) {

//        Producto Product = context.bodyAsClass(Producto.class);
//        System.out.println("Producto: " + Product);

        HashMap<String, Object> product = context.bodyAsClass(HashMap.class);

        IProductoFactory productoFactory = null;

        switch ((String) product.get("gama")) {
            case "alta": productoFactory = new GamaAltaFactory(); break;
            case "media": productoFactory = new GamaMediaFactory(); break;
            case "baja": productoFactory = new GamaBajaFactory(); break;
        }

        assert productoFactory != null;
        Producto producto = new Producto(
            (String) product.get("codigo"),
            (String) product.get("descripcion"),
            (double) product.get("precioBase"),
            productoFactory.getLineaProducto().getLinea(),
            productoFactory.getMantenimiento().getPeriodo(),
            productoFactory.getCamaraProducto().getCamaraFrontal(),
            productoFactory.getCamaraProducto().getCamaraTrasera(),
            productoFactory.getBateria().getDuracionBateria()
        );

        productRepository.create(producto);
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(producto.getId()));

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

        //FAbrica de gama media
        factoryProduct = new GamaMediaFactory();
        String LineaC = factoryProduct.getLineaProducto().getLinea();
        String mantenimientoC = factoryProduct.getMantenimiento().getPeriodo();

        //camara frontal de gama media
        String camaraFront = factoryProduct.getCamaraProducto().getCamaraFrontal();

        //Camara trasera de gama media
        String camaraTras = factoryProduct.getCamaraProducto().getCamaraTrasera();

        //Bateria de gama media
        String bateria = factoryProduct.getBateria().getDuracionBateria();



        Producto pr1 = new Producto("P01010016","Samsung S10", 2500.00, lineaA, mantenimientoA);
        productRepository.create(pr1);
        Producto pr2 = new Producto("P01010017","Samsung A10", 1000.00, lineaB, mantenimientoB);
        productRepository.create(pr2);
        Producto pr3 = new Producto("P01010018","Samsung S20", 3000.00, lineaA, mantenimientoA);
        productRepository.create(pr3);

       Producto pr4 = new Producto("P01010018","Xiaomi A1",1000.00,LineaC,mantenimientoC,camaraFront,camaraTras,bateria);
       // productRepository.create(pr4);

    }
    
}