package co.com.segurossura.certification.soat.models.basedatos;

import lombok.Getter;
import lombok.Setter;

public class Parametros {
  @Getter @Setter private String tabla;
  @Getter @Setter private String columna;
  @Getter @Setter private String dato;
  @Getter @Setter private String bundle;
}
