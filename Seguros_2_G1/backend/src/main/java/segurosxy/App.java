package segurosxy;

import io.javalin.core.JavalinConfig;
import segurosxy.cliente.model.*;
import segurosxy.cliente.model.Beneficiario;
import segurosxy.cliente.model.ClienteAsegurado;
import segurosxy.modelos.*;
import segurosxy.modelos.interfaces.ICobertura;
import segurosxy.modelos.patrones.*;

import io.javalin.Javalin;
import segurosxy.cliente.ClienteController;
import segurosxy.modelos.patrones.beneficiarios.Empleado;
import segurosxy.modelos.patrones.cobertura.CoberturaBasicaVehicular;
import segurosxy.modelos.patrones.cobertura.CoberturaPorChoqueDecorator;
import segurosxy.modelos.patrones.cobertura.CoberturaPorRoboDecorator;
import segurosxy.modelos.patrones.cobertura.CoberturaTodoRiesgoDecorator;
import segurosxy.modelos.patrones.mediator.CorreoMediator;
import segurosxy.seguro.SeguroController;
import segurosxy.seguro.tarjeta.SeguroTarjeta;
import segurosxy.seguro.vehiculo.model.SeguroChoque;
import segurosxy.seguro.vehiculo.model.SeguroVehicular;

public class App {

    private final ClienteController clienteController;
    private final SeguroController seguroController;

    public App() {
        this.clienteController = new ClienteController();
        this.seguroController = new SeguroController();
    }

    public void init() {
        // All CORS
        Javalin javalin = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(7000);

        clienteEndPoints(javalin);
        seguroEndpoints(javalin);
    }

    public void clienteEndPoints(Javalin server) {
        server.post("clientes/", clienteController::createCliente);
        server.get("clientes/", clienteController::allClientes);
    }

    public void seguroEndpoints(Javalin server) {
        server.post("seguros/", seguroController::createSeguro);
    }

    public static void main(String[] args ) {

        Cliente cliente = new Cliente("Juan Perez");
    //Cliente para la prueba del seguro
        CorreoMediator correo = new CorreoMediator();
        ClienteAsegurado clienteAsegurado = new ClienteAsegurado("Roberto Perez",correo);


        SeguroVehicular seguro = new SeguroChoque("Toyota","Yaris");
        seguro.calcularRiesgo();

        // Uso del Decorator para agregar distintas coberturas
        ICobertura cobertura = new CoberturaPorChoqueDecorator(
            new CoberturaTodoRiesgoDecorator(
                new CoberturaPorRoboDecorator( new CoberturaBasicaVehicular() ) ) );

    //servicio tecnico
        ServicioTecnico tecnico = new ServicioTecnico("DercoCenter");
    //Agrego observadores al Seguro
        seguro.addObserver(clienteAsegurado);
        seguro.addObserver(tecnico);

    //le doy la cobertura extendida al seguro
        seguro.setCobertura(cobertura);
    //ocurre un accidente CHOQUE
    //verifico si la cobertura lo cubre
        seguro.validarSeguro("Cobertura Afectacion Terceros");
        seguro.validarSeguro("Cobertura Choque");

        seguro.calcularCobeturaVehicular( cobertura );

        cliente.setCompraSeguro(seguro);
        //System.out.println( seguro.getDetalleSeguro() );

        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP");
        seguro2.calcularRiesgo();
        seguro2.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez"));
        cliente.setCompraSeguro(seguro2);
        //System.out.println( seguro2.getDetalleSeguro() );

        System.out.println();
        IImprimible polizaImprimible = new PolizaAdapter2( 122122, "Juan Pablo", "Juan Perez" );
        try {
            Impresora.imprimir( polizaImprimible.armarSalidaTexto() );

        } catch(Exception e) {
            e.printStackTrace();
        }

        //  Agregando Ubigeos de Casa y Trabajo
//        UbigeoContext ubigeoCasa = new UbigeoContext("01", "01", "01");
//        cliente.getUbigeos().put("ubigeoCasa", ubigeoCasa );
//
//        UbigeoContext ubigeoTrabajo = new UbigeoContext("01", "02", "01");
//        cliente.getUbigeos().put("ubigeoTrabajo", ubigeoTrabajo );
//
//        cliente.printUbigeos();


        // Correo Mediator
        System.out.println("\n[App] Notificaciones con CorreoMediator");
        CorreoMediator correoMediator = new CorreoMediator();
        ClienteAsegurado asegurado = new ClienteAsegurado("Pedro Pablo", correoMediator);
//        asegurado.enviaCorreo();

        //creo mas observadores
        PersonaObserver agente = new Agente("Eduardo Cruzado",correoMediator);
        PersonaObserver beneficiario = new Beneficiario("Josue Vallejo",correoMediator);
        PersonaObserver contratante = new Contratante("Hugo Ciro",correoMediator);

        // Agregando Observadores
        System.out.println("\n[App] Observador para cambio en Suma Asegurada");
        seguro2.addObserver(cliente);
        seguro2.addObserver(asegurado);

        //agrego mas observadores
        seguro2.addObserver(agente);
        seguro2.addObserver(beneficiario);
        seguro2.addObserver(contratante);


        seguro2.setSumaAsegurada(100000.00);//notifica

        // Command by SeguroEmpresa
        System.out.println("\n[App] Logica comando para empleados");
        SeguroEmpresa seguro3 = new SeguroEmpresa("Minera XYZ");
        Beneficiario minero1 = new Beneficiario("Luis Piedrahita");
        ICommand alta = new AltaCommand();
        ICommand baja = new BajaCommand();
        ICommand suspension = new SuspensionCommand();

        // TODO arreglar conflicto de Beneficiarios
        seguro3.setCommand(alta);
        seguro3.ejecutarAccion(minero1);

        seguro3.setCommand(baja);
        seguro3.ejecutarAccion(minero1);

        //beneficiario Empleado
        System.out.println("\n");
        SeguroEmpresa seguro4 = new SeguroEmpresa("Farmacia XYZ");
        Beneficiario farmaceutico = new Beneficiario("Eduardo Lanasca");

        seguro4.setCommand(suspension);
        seguro4.ejecutarAccion(farmaceutico);

        seguro4.setCommand(alta);
        seguro4.ejecutarAccion(farmaceutico);


        new App().init();
    }

}
