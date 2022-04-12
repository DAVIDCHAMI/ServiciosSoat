package co.com.segurossura.certification.soat.tasks.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.integrations.EliminaRegistroBaseDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EliminarRegistroBaseDatos implements Task, CanBeSilent {

  Parametros parametros = new Parametros();

  public EliminarRegistroBaseDatos(String bundle, String tabla, String columna, String datos) {
    parametros.setBundle(bundle);
    parametros.setTabla(tabla);
    parametros.setColumna(columna);
    parametros.setDato(datos);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    EliminaRegistroBaseDatos.eliminarRegistroBD(parametros);
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static EliminarRegistroBaseDatos conLosDatos(
      String bundle, String tabla, String columna, String datos) {
    return instrumented(EliminarRegistroBaseDatos.class, bundle, tabla, columna, datos);
  }
}
