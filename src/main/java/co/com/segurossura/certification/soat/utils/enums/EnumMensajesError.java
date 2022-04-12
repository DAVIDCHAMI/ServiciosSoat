package co.com.segurossura.certification.soat.utils.enums;

public enum EnumMensajesError {
  VALIDACION_SOAT_VIGENTE(
      "Ya cuentas con un SOAT vigente para la fecha ingresada. Por favor ingresa una fecha de inicio de vigencia mayor al "),
  MENSAJE_ERROR_COTIZACION_SOAT_CON_SOAT_VIGENTE(
      "En este momento tienes el SOAT vigente. Recuerda que puedes comprarlo hasta 6 meses antes de su vencimiento."),
  MENSAJE_ERROR_EXPEDICION_SOAT_CON_FECHA_ACTUAL(
      "La fecha de inicio de vigencia debe ser mayor al día de hoy"),
  MENSAJE_ERROR_SOAT_FECHA_VENCIMIENTO_MAYOR_6_MESES(
      "En este momento tienes el SOAT vigente. Recuerda que puedes comprarlo hasta 6 meses antes de su vencimiento."),
  NIVEL_RIESGO_CLIENTE("El nivel de riesgo del cliente es alto");

  private final String valorMensajeError;

  EnumMensajesError(String nombre) {
    this.valorMensajeError = nombre;
  }

  public String getMensajesError() {
    return valorMensajeError;
  }
}
