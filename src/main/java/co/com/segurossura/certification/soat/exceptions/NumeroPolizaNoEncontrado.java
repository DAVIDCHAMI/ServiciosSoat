package co.com.segurossura.certification.soat.exceptions;

public class NumeroPolizaNoEncontrado extends AssertionError {

  public static final String NUMERO_POLIZA_ERRADO =
      "El numero de poliza obtenido no es igual al esperado";

  public NumeroPolizaNoEncontrado(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
