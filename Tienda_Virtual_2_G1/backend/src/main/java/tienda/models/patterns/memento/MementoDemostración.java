package tienda.models.patterns.memento;

import tienda.models.Cliente;

public class MementoDemostración {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();


        //se crea un cliente (datos)
        String id1 = "1";
        String nombre = "Juan";
        String numeroDocumento = "72394846";
        String correo = "jjgg@gmail.com";

        Cliente cliente = new Cliente(nombre, numeroDocumento, correo);
        cliente.setId(id1);

        //se guardan los datos cliente 1
        originator.set(cliente);
        caretaker.addMemento( originator.guardandoParaMemento() );
        System.out.println("\n");

        //cambio 1 dni cliente 1
        correo = "juangg@gmail.com";
        cliente = new Cliente(nombre, numeroDocumento,correo);
        cliente.setId(id1);
        originator.set(cliente);
        caretaker.addMemento( originator.guardandoParaMemento() );
        System.out.println("\n");


        //cambio 2 dni y 1 nombre cliente 1
        nombre = "Pepe";
        correo = "jjgonzalesg@gmail.com";
        cliente = new Cliente(nombre, numeroDocumento,correo);
        cliente.setId(id1);
        originator.set(cliente);
        caretaker.addMemento( originator.guardandoParaMemento() );
        System.out.println("\n");

        cliente = originator.restaurandoDesdeMemento( caretaker.getMemento(2) );
        System.out.println(cliente.toString()+"\n");

        System.out.println("--------------------------------------------------------------------------");
        /*-----------------------------------------------------------------------------------------*/

        /*
        Caretaker caretaker2 = new Caretaker();
        Originator originator2 = new Originator();
        //se crea un cliente 2 (datos)
        String id2 = "2";
        String nombre2 = "Eduardo";
        String numeroDocumento2 = "72390000";
        String correo2 = "eduJL@gmail.com";

        Cliente cliente2 = new Cliente(nombre2, numeroDocumento2, correo2);
        cliente2.setId("2");

        //datos iniciales guardados
        originator2.set(cliente2);
        caretaker2.addMemento( originator2.guardandoParaMemento() );
        System.out.println("\n");

        //cambios cliente 2
        //cambio 1 correo cliente 2
        correo2 = "EduardoLanazca@gmail.com";
        cliente2 = new Cliente(nombre2, numeroDocumento2,correo2);
        cliente.setId(id2);
        originator2.set(cliente2);
        caretaker2.addMemento( originator2.guardandoParaMemento() );
        System.out.println("\n");

        //cambio 2 dni y 1 nombre cliente 2
        nombre2 = "Edu";
        correo2 = "ejlc@gmail.com";
        cliente2 = new Cliente(nombre2, numeroDocumento2,correo2);
        cliente.setId(id2);
        originator2.set(cliente2);
        caretaker2.addMemento( originator2.guardandoParaMemento() );
        System.out.println("\n");

        cliente2 = originator2.restaurandoDesdeMemento( caretaker2.getMemento(0) );
        System.out.println(cliente2.toString()+"\n");

        */
    }
}
