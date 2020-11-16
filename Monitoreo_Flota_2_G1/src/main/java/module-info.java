module MonitoreoXY {

  requires javafx.base;
  requires javafx.controls;
  requires javafx.swing;
  requires com.esri.arcgisruntime;

  exports monitoreo.modelos to javafx.graphics;
  exports monitoreo to javafx.graphics;
  exports monitoreo.modelos.interfaces;
  exports monitoreo.modelos.impl;
}