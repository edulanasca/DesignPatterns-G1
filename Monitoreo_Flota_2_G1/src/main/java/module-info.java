module MonitoreoXY {

  requires javafx.base;
  requires javafx.controls;
  requires com.esri.arcgisruntime;

  exports monitoreo.modelos to javafx.graphics;
  exports monitoreo.modelos.interfaces;
  exports monitoreo.modelos.impl;
}