package co.com.segurossura.certification.soat.utils.enums;

public enum EnumFiltrosEstructuras {
  NUMERO_PLACA("numeroPlaca");

  private final String filtro;

  EnumFiltrosEstructuras(String filtro) {
    this.filtro = filtro;
  }

  public String getFiltro() {
    return filtro;
  }
}
