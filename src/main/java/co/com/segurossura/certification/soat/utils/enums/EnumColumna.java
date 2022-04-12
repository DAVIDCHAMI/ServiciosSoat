package co.com.segurossura.certification.soat.utils.enums;

public enum EnumColumna {
  PLACA_RUNT("DSPLACAOVIN"),
  NUMERO_POLIZA("NMPOLIZA"),
  NUMERO_PLACA("CDPLACA"),
  VALOR_PARAMETRO("DSVALOR");

  private final String columna;

  EnumColumna(String columna) {
    this.columna = columna;
  }

  public String getColumna() {
    return columna;
  }
}
