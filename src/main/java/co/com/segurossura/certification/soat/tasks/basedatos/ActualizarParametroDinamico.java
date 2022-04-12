package co.com.segurossura.certification.soat.tasks.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ActualizarParametroDinamico implements Task, CanBeSilent {

  @Override
  public <T extends Actor> void performAs(T actor) {
    ActualizarRegistro.parametroDinamico();
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static ActualizarParametroDinamico conLosDatos() {
    return instrumented(ActualizarParametroDinamico.class);
  }
}
