package co.com.segurossura.certification.soat.interactions.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.integrations.ActualizaRegistroBaseDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ActualizarDatos implements Interaction, CanBeSilent {

  private final Parametros parametros;

  public ActualizarDatos(Parametros parametros) {
    this.parametros = parametros;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    ActualizaRegistroBaseDatos.actualizarRegistroBD(parametros);
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static ActualizarDatos conLosParametros(Parametros parametros) {
    return instrumented(ActualizarDatos.class, parametros);
  }
}
