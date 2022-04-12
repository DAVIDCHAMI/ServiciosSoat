package co.com.segurossura.certification.soat.exceptions;

public class ValorTarifaError extends AssertionError {

  public static final String VALOR_TARIFA_ERRADO =
      "El valor de la tarifa obtenido no es igual al esperado";

  public ValorTarifaError(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
