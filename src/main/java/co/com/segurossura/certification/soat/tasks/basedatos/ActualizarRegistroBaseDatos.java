package co.com.segurossura.certification.soat.tasks.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.basedatos.ActualizarDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ActualizarRegistroBaseDatos implements Task, CanBeSilent {

  Parametros parametros = new Parametros();

  public ActualizarRegistroBaseDatos(String bundle, String tabla, String columna, String datos) {
    parametros.setBundle(bundle);
    parametros.setTabla(tabla);
    parametros.setColumna(columna);
    parametros.setDato(datos);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ActualizarDatos.conLosParametros(parametros));
  }

  @Override
  public boolean isSilent() {
    return false;
  }

  public static ActualizarRegistroBaseDatos conLosDatos(
      String bundle, String tabla, String columna, String datos) {
    return instrumented(ActualizarRegistroBaseDatos.class, bundle, tabla, columna, datos);
  }
}
