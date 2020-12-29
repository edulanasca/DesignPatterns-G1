package com.grupouno.teatro.ticket;


import com.grupouno.teatro.butacas.*;
import com.grupouno.teatro.obra.Obra;
import com.grupouno.teatro.obra.ObraComedia;
import com.grupouno.teatro.obra.ObraDrama;
import com.grupouno.teatro.tarjeta.MetodoPago;
import com.grupouno.teatro.tarjeta.MetodoPagoPaypal;
import com.grupouno.teatro.tarjeta.MetodoPagoTarjeta;

public class FacadeTicket {

  private final String nombre;
  private final java.util.List<Integer> asientos;
  private Sector sector;
  private Obra obra;
  private MetodoPago metodoPago;

  public FacadeTicket(Cliente cliente) {

    nombre = cliente.getNombre();
    asientos = cliente.getAsientos();

    SectorGeneral general = new SectorGeneral();

    asientos.forEach(asiento -> general.agregarButaca(new Asiento(asiento)));

    switch (cliente.getSector()) {
      case "palco":
        sector = new SectorPalco(new SectorGeneral());
        break;
      case "premium":
        sector = new SectorPremium(new SectorGeneral()); break;
    }


    switch (cliente.getTipoObra()) {
      case "comedia":
        obra = new ObraComedia(); break;
      case "drama":
        obra = new ObraDrama(); break;
    }

    switch (cliente.getMetodoPago()) {
      case "paypal":
        metodoPago = new MetodoPagoPaypal(); break;
      case "tarjeta":
        metodoPago = new MetodoPagoTarjeta(); break;
    }

  }

  public Ticket generarTicket() {
    Ticket ticket = new Ticket();
    ticket.setNombreCliente(nombre);
    ticket.setAsientos(sector);
    ticket.setNumAsientos(asientos.size());
    ticket.setObra(obra);

    double total = sector.calcularCosto();

    ticket.setCostoTotal(total);
    ticket.setMetodoPago(metodoPago.pagar(total));

    return ticket;
  }

}
