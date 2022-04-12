package co.com.segurossura.certification.soat.exceptions;

public class CodigoRespuestaServicioError extends AssertionError {

  public static final String CODIGO_RESPUESTA_SERVICIO =
      "El código de respuesta obtenido no es igual al esperado";

  public CodigoRespuestaServicioError(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
