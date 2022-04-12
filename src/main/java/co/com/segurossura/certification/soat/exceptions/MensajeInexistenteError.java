package co.com.segurossura.certification.soat.exceptions;

public class MensajeInexistenteError extends AssertionError {

  public static final String MENSAJE_INEXISTENTE_ERROR =
      "El mensaje de error esperado no está contenido dentro de los errores obtenidos";

  public MensajeInexistenteError(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
