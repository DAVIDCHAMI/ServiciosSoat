package co.com.segurossura.certification.soat.utils.enums;

public enum EnumCodigoEstado {
  ESTADO_OK("1"),
  ESTADO_DATOS_ERRADOS_RUNT("2"),
  ESTADO_DATOS_ERRADOS_USUARIO("3"),
  ESTADO_DATOS_ERRADOS_RUNT_Y_USUARIO("4"),
  ESTADO_DATOS_ERRADOS_VALIDACION_PREPOLIZA("5");

  private final String codigoEstado;

  EnumCodigoEstado(String codigoEstado) {
    this.codigoEstado = codigoEstado;
  }

  public String getCodigoEstado() {
    return codigoEstado;
  }
}
