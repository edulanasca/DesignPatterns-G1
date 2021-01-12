package segurosxy.cliente.model;

import org.bson.types.ObjectId;
import segurosxy.modelos.patrones.mediator.ICorredorMediator;

public abstract class PersonaObserver//es un obserbador
{

//datos de toda persona
   private String id;
   private String nombre;
   protected ICorredorMediator correoMediator;

   public PersonaObserver() {
   }

   //constructores persona
   public PersonaObserver(String nombre) {
      this.id = new ObjectId().toString();
      this.nombre = nombre;
   }

   public PersonaObserver(final String nombre, final ICorredorMediator correoMediator) {
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

   public ICorredorMediator getCorreoMediator() {return correoMediator;}
   public void setCorreoMediator(final ICorredorMediator correoMediator) {
      this.correoMediator = correoMediator;}


}
