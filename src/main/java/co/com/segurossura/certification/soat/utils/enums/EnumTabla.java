package co.com.segurossura.certification.soat.utils.enums;

public enum EnumTabla {
  TABLA_CONSUMO_RUNT("TSOAT_CONSUMOS_RUNT"),
  TABLA_SOAT_POLIZAS("Tsoat_Polizas"),
  TABLA_SOAT_SIIS("TSOAT_REPORTE_SIIS"),
  TABLA_PARAMETRIZACION_CANAL("TSOAT_PARAM_CANAL");

  private final String tabla;

  EnumTabla(String tabla) {
    this.tabla = tabla;
  }

  public String getTabla() {
    return tabla;
  }
}
