package co.com.segurossura.certification.soat.tasks.expedicion;

import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios.SERVICIOS_SOAT;
import static co.com.segurossura.certification.soat.utils.enums.EnumRecursosServicios.EXPEDICION;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.REQUEST_EXPEDICION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.servicios.ConsumirServicio;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ExpedirPoliza implements Task {

  Map<String, String> header = new HashMap<>();

  public ExpedirPoliza() {
    header.put("X-Consumer-Key", "Bancolombia");
  }

  @Step("{0} expide el SOAT exitosamente")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        ConsumirServicio.postConHeaders(
            EXPEDICION.getRecurso(),
            SERVICIOS_SOAT,
            actor.recall(REQUEST_EXPEDICION.getVariableSesion()),
            header));
  }

  public static ExpedirPoliza paraElVehiculo() {
    return instrumented(ExpedirPoliza.class);
  }
}
