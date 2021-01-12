module Seguros {
  requires javafx.base;
  requires javafx.controls;

  requires io.javalin;
  requires org.eclipse.jetty.http;
  requires mongo.java.driver;

  requires static lombok;

  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires javax.mail;

  opens segurosxy.modelos.patrones.cobertura;
  exports segurosxy.modelos.patrones.cobertura.vista to javafx.graphics;

  exports segurosxy.modelos to mongo.java.driver, com.fasterxml.jackson.databind;
  exports segurosxy.modelos.interfaces to mongo.java.driver, com.fasterxml.jackson.databind;

  exports segurosxy.modelos.patrones to mongo.java.driver, com.fasterxml.jackson.databind;
  exports segurosxy.seguro to mongo.java.driver, com.fasterxml.jackson.databind;
  exports segurosxy.seguro.tarjeta to mongo.java.driver, com.fasterxml.jackson.databind;
  exports segurosxy.seguro.vehiculo to mongo.java.driver, com.fasterxml.jackson.databind;
  exports segurosxy.seguro.vehiculo.model to mongo.java.driver,com.fasterxml.jackson.databind;
  exports segurosxy.modelos.patrones.mediator;
}