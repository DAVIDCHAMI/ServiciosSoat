package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.REQUEST_EXPEDICION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.models.comunes.RequestPolizaSoat;
import co.com.segurossura.certification.soat.utils.Fechas;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AgregarInicioVigencia implements Task, CanBeSilent {

  private final String fechaInicioVigencia;
  RequestPolizaSoat requestExpedicionSoat =
      theActorInTheSpotlight().recall(REQUEST_EXPEDICION.getVariableSesion());

  public AgregarInicioVigencia(String fechaInicioVigencia) {
    this.fechaInicioVigencia = fechaInicioVigencia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    requestExpedicionSoat.setFechaInicioVigencia(Fechas.fechaVigenciaSoat(fechaInicioVigencia));
    actor.remember(REQUEST_EXPEDICION.getVariableSesion(), requestExpedicionSoat);
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static AgregarInicioVigencia conFecha(String fechaInicioVigencia) {
    return instrumented(AgregarInicioVigencia.class, fechaInicioVigencia);
  }
}
