package co.com.segurossura.certification.soat.question.validacionprepoliza;

import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeRespuestaErrorValidacionPrepoliza implements Question<String> {
  private ResponsePolizaSoat responsePolizaSoat;

  public MensajeRespuestaErrorValidacionPrepoliza(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  public static MensajeRespuestaErrorValidacionPrepoliza deLaValidacion(
      ResponsePolizaSoat responsePolizaSoat) {
    return new MensajeRespuestaErrorValidacionPrepoliza(responsePolizaSoat);
  }

  @Override
  public String answeredBy(Actor actor) {
    return responsePolizaSoat.getMessage();
  }
}
