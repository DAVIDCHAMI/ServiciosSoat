package co.com.segurossura.certification.soat.question.comunes;

import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NumeroPoliza implements Question<String> {

  private final ResponsePolizaSoat responsePolizaSoat;

  public NumeroPoliza(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  public static NumeroPoliza expedido(ResponsePolizaSoat responsePolizaSoat) {
    return new NumeroPoliza(responsePolizaSoat);
  }

  @Override
  public String answeredBy(Actor actor) {
    return responsePolizaSoat.getPoliza();
  }
}
