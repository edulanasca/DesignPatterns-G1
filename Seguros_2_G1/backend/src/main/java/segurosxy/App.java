package segurosxy;

import io.javalin.Javalin;
import segurosxy.cliente.ClienteController;

public class App {

    private final ClienteController clienteController;

    public App() {
        this.clienteController = new ClienteController();
    }

    public void init() {
        Javalin javalin = Javalin.create().start(7000);

        clienteEndPoints(javalin);
    }

    public void clienteEndPoints(Javalin server) {
        server.post("clientes/", clienteController::createCliente);
        server.get("clientes/", clienteController::allClientes);
    }

    public static void main(String[] args ) { new App().init(); }

}
