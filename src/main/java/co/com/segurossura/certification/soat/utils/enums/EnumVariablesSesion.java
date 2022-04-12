package co.com.segurossura.certification.soat.utils.enums;

public enum EnumVariablesSesion {
  CATEGORIA_FILTRADA("Categoría filtrada"),
  COBERTURA_FILTRADA("Cobertura filtrada"),
  LISTA_ERRORES("Lista de errores"),
  OPCION_FILTRADA("Opción filtrada"),
  REQUEST_TARIFA("Request tarifa"),
  TERMINO_FILTRADO("Término filtrado"),
  REQUEST_COTIZACION("Request cotización"),
  REQUEST_EXPEDICION("requestExpedicion"),
  RESULTADO_CONSULTA_OBTENIDO("numeroPoliza"),
  CARACTERISTICAS_VEHICULO_JSON("Características del vehículo con estructura Json"),
  PLACA_VEHICULO("Placa del vehículo"),
  FECHA_FIN_VIGENCIA("fechaFinVigencia"),
  RETORNO_CONSULTA_BD("retornoConsultaBaseDatos");

  private final String variableSesion;

  EnumVariablesSesion(String variableSesion) {
    this.variableSesion = variableSesion;
  }

  public String getVariableSesion() {
    return variableSesion;
  }
}
