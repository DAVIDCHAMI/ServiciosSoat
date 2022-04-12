package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.REQUEST_EXPEDICION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.models.builder.expedicion.RequestExpedicionBuilder;
import lombok.SneakyThrows;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AgregarDatosRequestPoliza implements Task, CanBeSilent {

  private final String tipoRiesgo;

  public AgregarDatosRequestPoliza(String tipoRiesgo) {
    this.tipoRiesgo = tipoRiesgo;
  }

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(
        REQUEST_EXPEDICION.getVariableSesion(),
        RequestExpedicionBuilder.conLosDatos(
            tipoRiesgo, theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static AgregarDatosRequestPoliza conTipoRiesgo(String tipoRiesgo) {
    return instrumented(AgregarDatosRequestPoliza.class, tipoRiesgo);
  }
}
