package com.grupouno.teatro.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
  private String nombre;
  private List<Integer> asientos;
  private String metodoPago;
  private String sector;
  private String tipoObra;
}
