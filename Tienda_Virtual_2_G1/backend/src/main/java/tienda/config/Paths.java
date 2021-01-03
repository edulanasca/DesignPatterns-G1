package tienda.config;

public class Paths {
    public static final String INDEX = "/api";

    public static final String CLIENTE = "customers";
    public static final String PEDIDOS = "orders";

    public static final String ID_PARAM = ":id";

    public static String formatPostLocation(String id) {
        return String.format("%s/%s/%s", INDEX, PEDIDOS, id);
    }

    public static String formatClientLocation(String id) {
        return String.format("%s/%s/%s", INDEX, CLIENTE, id);
    }
}