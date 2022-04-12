package co.com.segurossura.certification.soat.question.comunes;

import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ListaMensajesDatosErradosPoliza implements Question<List<String>> {

  private final ResponsePolizaSoat responsePolizaSoat;

  public ListaMensajesDatosErradosPoliza(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  public static ListaMensajesDatosErradosPoliza obtenido(ResponsePolizaSoat responsePolizaSoat) {
    return new ListaMensajesDatosErradosPoliza(responsePolizaSoat);
  }

  @Override
  public List<String> answeredBy(Actor actor) {
    List<String> lstErroresPoliza = new ArrayList<>();
    responsePolizaSoat
        .getDatosErradosPoliza()
        .forEach(
            datosErradosPoliza ->
                lstErroresPoliza.addAll(datosErradosPoliza.getDescripcionError()));
    return lstErroresPoliza;
  }
}
