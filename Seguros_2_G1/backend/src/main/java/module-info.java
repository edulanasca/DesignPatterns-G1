module Seguros {
  requires javafx.base;
  requires javafx.controls;

  requires io.javalin;
  requires org.eclipse.jetty.http;
  requires mongo.java.driver;

  requires static lombok;

  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;

  opens segurosxy.modelos.patrones.cobertura;
  exports segurosxy.modelos.patrones.cobertura.vista to javafx.graphics;
}