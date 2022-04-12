package co.com.segurossura.certification.soat.utils.enums;

public enum EnumConstantesCsv {
  RUTA_RECURSOS_DATOS_CSV("src/test/resources/data/"),
  PREFIJO_NOMBRE_DATOS_CSV("datos_"),
  EXTENSION_NOMBRE_DATOS_CSV(".csv"),
  NOMBRE_COLUMNA_FILTRO("idFiltro");

  private final String constanteCsv;

  EnumConstantesCsv(String nombre) {
    this.constanteCsv = nombre;
  }

  public String getConstanteCsv() {
    return constanteCsv;
  }
}
