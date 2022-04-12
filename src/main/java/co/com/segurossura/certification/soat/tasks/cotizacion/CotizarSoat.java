package co.com.segurossura.certification.soat.tasks.cotizacion;

import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios.SERVICIOS_SOAT;
import static co.com.segurossura.certification.soat.utils.enums.EnumRecursosServicios.COTIZACION;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.REQUEST_COTIZACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.servicios.ConsumirServicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class CotizarSoat implements Task {

  public static CotizarSoat paraElVehiculo() {
    return instrumented(CotizarSoat.class);
  }

  @Step("{0} cotiza SOAT correctamente")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        ConsumirServicio.postSimple(
            COTIZACION.getRecurso(),
            SERVICIOS_SOAT,
            actor.recall(REQUEST_COTIZACION.getVariableSesion())));
  }
}
