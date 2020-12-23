package com.grupouno.teatro.ticket;

import com.grupouno.teatro.butacas.Sector;
import com.grupouno.teatro.obra.Obra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
  @Id
  private String id;
  private String nombreCliente;
  private Obra obra;
  private Sector asientos;
  private int numAsientos;
  private double costoTotal;
  private String metodoPago;

}
