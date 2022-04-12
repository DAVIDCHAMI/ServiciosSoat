package co.com.segurossura.certification.soat.question.comunes;

import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoEstado implements Question<String> {

  private final ResponsePolizaSoat responsePolizaSoat;

  public CodigoEstado(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  public static CodigoEstado obtenido(ResponsePolizaSoat responsePolizaSoat) {
    return new CodigoEstado(responsePolizaSoat);
  }

  @Override
  public String answeredBy(Actor actor) {
    return responsePolizaSoat.getCodigoEstado();
  }
}
