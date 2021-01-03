package tienda;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;

import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import tienda.config.DBConnectionManager;
import tienda.controllers.impl.CustomerControllerImpl;
import tienda.controllers.impl.OrderControllerImpl;
import tienda.controllers.impl.ProductControllerImpl;
import tienda.repositories.impl.ClienteRepositorioImpl;
import tienda.repositories.impl.PedidoRepositorioImpl;
import tienda.repositories.impl.ProductoRepositorioImpl;

public class App {

    private final DBConnectionManager manager;
    private final CustomerControllerImpl customerController;
    private final OrderControllerImpl orderController;
    private final ProductControllerImpl productController;

    public App() {
        this.manager = new DBConnectionManager();

        ClienteRepositorioImpl customerRepositoryImpl = new ClienteRepositorioImpl(this.manager.getDatabase());
        this.customerController = new CustomerControllerImpl(customerRepositoryImpl);

        PedidoRepositorioImpl orderRepositoryImpl = new PedidoRepositorioImpl(this.manager.getDatabase());
        this.orderController = new OrderControllerImpl(orderRepositoryImpl);

        ProductoRepositorioImpl productRepositoryImpl = new ProductoRepositorioImpl(this.manager.getDatabase());
        this.productController = new ProductControllerImpl(productRepositoryImpl);
    }

    public void startup() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("Demo API");
        OpenApiOptions openApi = new OpenApiOptions(applicationInfo)
                .path("/api")
                .swagger(new SwaggerOptions("/api-ui")); // endpoint for swagger-ui
        Javalin server = Javalin.create(
                config -> {
                    config.registerPlugin(new OpenApiPlugin(openApi));
                    config.enableCorsForAllOrigins(); // All CORS
                }
        ).start(7000);

        server.get("api/customers/:id", this.customerController::find);
        server.put("api/customers/:id", this.customerController::update);
        server.delete("api/customers/:id", this.customerController::delete);
        server.get("api/customers", this.customerController::findAll);
        server.post("api/customers", this.customerController::create);

        server.get("api/orders/:id", this.orderController::find);
        server.delete("api/orders/:id", this.orderController::delete);
        server.get("api/orders", this.orderController::findAll);
        server.post("api/orders", this.orderController::create);

        server.get("api/products/:id", this.productController::find);
        server.delete("api/products/:id", this.productController::delete);
        server.get("api/products", this.productController::findAll);
        server.post("api/products", this.productController::create);
        server.post("api/loadProducts", this.productController::loadProducts);

        //server.post("api/order/pay/:id", this.orderController::pay);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            this.manager.closeDatabase();
            server.stop();
        }));
    }

    public static void main(String[] args) {
        new App().startup();
    }
}
