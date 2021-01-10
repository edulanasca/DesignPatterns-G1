package segurosxy.cliente.model;

import org.bson.types.ObjectId;
import segurosxy.modelos.patrones.CorreoMediator;
import segurosxy.modelos.patrones.UbigeoContext;

import java.util.Map;

public abstract class Persona {

   //datos de toda persona
   private String id;
   private String nombre;
   protected CorreoMediator correoMediator;

//constructores persona
   public Persona(String nombre) {
      this.id = new ObjectId().toString();
      this.nombre = nombre;
   }

   public Persona(final String nombre, final CorreoMediator correoMediator) {
      this.id = new ObjectId().toString();
      this.nombre = nombre;
      this.correoMediator = correoMediator;
   }

//mettodo abastracto para notificar
   public abstract void notifica();



//Getters y setters de los datos de persona
   public String getId() {return id;}
   public void setId(String id) {this.id = id;}

   public String getNombre(){return this.nombre;};
   public void setNombre(String nombre) {this.nombre = nombre;}

   public CorreoMediator getCorreoMediator() {return correoMediator;}
   public void setCorreoMediator(final CorreoMediator correoMediator) {
      this.correoMediator = correoMediator;}


}
