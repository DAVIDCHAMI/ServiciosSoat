package co.com.segurossura.certification.soat.tasks.validacionprepoliza;

import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios.SERVICIOS_SOAT;
import static co.com.segurossura.certification.soat.utils.enums.EnumRecursosServicios.VALIDACIONES_PREPOLIZA;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.REQUEST_EXPEDICION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.servicios.ConsumirServicio;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ValidarPrepoliza implements Task {

  Map<String, String> header = new HashMap<>();

  public ValidarPrepoliza() {
    header.put("X-Consumer-Key", "Bancolombia");
  }

  @Step("{0} valida el SOAT")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        ConsumirServicio.postConHeaders(
            VALIDACIONES_PREPOLIZA.getRecurso(),
            SERVICIOS_SOAT,
            actor.recall(REQUEST_EXPEDICION.getVariableSesion()),
            header));
  }

  public static ValidarPrepoliza conLosDatos() {
    return instrumented(ValidarPrepoliza.class);
  }
}
