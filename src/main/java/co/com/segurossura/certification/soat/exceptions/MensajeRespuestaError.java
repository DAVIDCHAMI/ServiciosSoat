package co.com.segurossura.certification.soat.exceptions;

public class MensajeRespuestaError extends AssertionError {

  public static final String MENSAJE_RESPUESTA_ERROR =
      "El mensaje de respuesta obtenido no es igual al esperado";

  public MensajeRespuestaError(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
