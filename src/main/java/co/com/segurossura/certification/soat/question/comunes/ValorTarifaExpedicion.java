package co.com.segurossura.certification.soat.question.comunes;

import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValorTarifaExpedicion implements Question<Float> {

  private final ResponsePolizaSoat responsePolizaSoat;

  public ValorTarifaExpedicion(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  public static ValorTarifaExpedicion obtenido(ResponsePolizaSoat responsePolizaSoat) {
    return new ValorTarifaExpedicion(responsePolizaSoat);
  }

  @Override
  public Float answeredBy(Actor actor) {
    return responsePolizaSoat.getCotizacion().getCostoTotal();
  }
}
