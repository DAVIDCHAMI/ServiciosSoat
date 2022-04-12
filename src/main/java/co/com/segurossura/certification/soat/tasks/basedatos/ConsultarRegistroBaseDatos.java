package co.com.segurossura.certification.soat.tasks.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.basedatos.ConsultarDatos;
import co.com.segurossura.certification.soat.interactions.basedatos.RetornoConsultaBD;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsultarRegistroBaseDatos implements Task, CanBeSilent {

  Parametros parametros = new Parametros();

  public ConsultarRegistroBaseDatos(String bundle, String tabla, String columna, String datos) {
    parametros.setBundle(bundle);
    parametros.setTabla(tabla);
    parametros.setColumna(columna);
    parametros.setDato(datos);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsultarDatos.conLosParametros(parametros));
    actor.attemptsTo(RetornoConsultaBD.conLosDatos(0, "NMPOLIZA"));
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static ConsultarRegistroBaseDatos conLosDatos(
      String bundle, String tabla, String columna, String datos) {
    return instrumented(ConsultarRegistroBaseDatos.class, bundle, tabla, columna, datos);
  }
}
