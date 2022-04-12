package co.com.segurossura.certification.soat.utils.enums;

public enum EnumCredencialesBaseDatos {
  BASE_DATOS_SOAT("jdbc:oracle:thin:@mdebdl05.suranet.com:1537:LABSOAT", "soat", "soat");

  private final String urlBaseDatos;
  private final String usuario;
  private final String contrasena;

  EnumCredencialesBaseDatos(String urlBaseDatos, String usuario, String contrasena) {
    this.urlBaseDatos = urlBaseDatos;
    this.usuario = usuario;
    this.contrasena = contrasena;
  }

  public String getUrlBaseDatos() {
    return urlBaseDatos;
  }

  public String getUsuario() {
    return usuario;
  }

  public String getContrasena() {
    return contrasena;
  }
}
