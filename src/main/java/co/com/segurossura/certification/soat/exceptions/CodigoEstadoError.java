package co.com.segurossura.certification.soat.exceptions;

public class CodigoEstadoError extends AssertionError {

  public static final String CODIGO_ESTADO_ERROR =
      "El código de estado obtenído no es igual al esperado";

  public CodigoEstadoError(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
