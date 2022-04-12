package co.com.segurossura.certification.soat.tasks.validacionprepoliza;

import co.com.segurossura.certification.soat.interactions.RegistrarEnConsola;
import co.com.segurossura.certification.soat.interactions.servicios.Put;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.utils.enums.EnumRecursosServicios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;

public class AnularPrepoliza implements Task {

  private final ResponsePolizaSoat responsePolizaSoat;

  public AnularPrepoliza(ResponsePolizaSoat responsePolizaSoat) {
    this.responsePolizaSoat = responsePolizaSoat;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Check.whether(responsePolizaSoat.getIdPago() != null)
            .andIfSo(
                Put.to(
                        responsePolizaSoat.getIdPago()
                            + EnumRecursosServicios.ANULAR_PREPOLIZA.getRecurso())
                    .with(
                        requestSpecification ->
                            requestSpecification.header("Origin", "https://lab.suraenlinea.com")))
            .otherwise(
                RegistrarEnConsola.elMensaje(
                    "AnularPrepoliza",
                    "La prepoliza no fue anulada. El idPago es: "
                        + responsePolizaSoat.getIdPago()
                        + "")));
  }

  public static AnularPrepoliza conIdDePago(ResponsePolizaSoat responsePolizaSoat) {
    return new AnularPrepoliza(responsePolizaSoat);
  }
}
