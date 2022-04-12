package co.com.segurossura.certification.soat.utils.enums;

public enum EnumSentenciasSQL {
  CONSULTAR_REGISTRO_NUMERO_POLIZA("SQL.CONSULTA.POLIZA"),
  INSERTAR_REGISTRO("SQL.INSERTAR.REGISTRO"),
  ELIMINAR_REGISTRO("SQL.ELIMINAR.REGISTRO"),
  ACTUALIZAR_REGISTRO("SQL.ACTUALIZAR.REGISTRO");

  private final String sentencia;

  EnumSentenciasSQL(String sentencia) {
    this.sentencia = sentencia;
  }

  public String getSentencia() {
    return sentencia;
  }
}
