package co.com.segurossura.certification.soat.tasks.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EliminarRegistroRuntPoliza implements Task, CanBeSilent {

  @Override
  public <T extends Actor> void performAs(T actor) {
    ConsultarRegistro.numeroPoliza();
    EliminarRegistro.vehiculoRunt();
    EliminarRegistro.polizaSoat();
    EliminarRegistro.polizaSiis();
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static EliminarRegistroRuntPoliza conLosDatos() {
    return instrumented(EliminarRegistroRuntPoliza.class);
  }
}
