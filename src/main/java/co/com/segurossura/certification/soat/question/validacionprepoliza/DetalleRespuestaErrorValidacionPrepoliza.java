package co.com.segurossura.certification.soat.question.validacionprepoliza;

import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DetalleRespuestaErrorValidacionPrepoliza implements Question<String> {
  private ResponsePolizaSoat responsePolizaSoat;

  public DetalleRespuestaErrorValidacionPrepoliza(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  public static DetalleRespuestaErrorValidacionPrepoliza deLaValidacion(
      ResponsePolizaSoat responsePolizaSoat) {
    return new DetalleRespuestaErrorValidacionPrepoliza(responsePolizaSoat);
  }

  @Override
  public String answeredBy(Actor actor) {
    return responsePolizaSoat.getDetail();
  }
}
