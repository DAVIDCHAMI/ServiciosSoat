package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CARACTERISTICAS_VEHICULO_JSON;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.interactions.basedatos.InsertarDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class RegistrarVehiculoBaseDatos implements Task, CanBeSilent {

  Parametros parametros = new Parametros();

  public RegistrarVehiculoBaseDatos() {
    parametros.setBundle("SQL.INSERTAR.REGISTRO");
    parametros.setTabla("TSOAT_CONSUMOS_RUNT");
    parametros.setColumna("CDCONSULTA,DSPLACAOVIN,FECONSULTA,CDCANAL,DSRESPUESTARUNT");
    parametros.setDato(
        "SEQ_SOAT_CONSUMOS_RUNT.nextval,'"
            + theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())
            + "',SYSDATE,287,'"
            + theActorInTheSpotlight().recall(CARACTERISTICAS_VEHICULO_JSON.getVariableSesion())
            + "'");
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(InsertarDatos.conLosParametros(parametros));
  }

  public static RegistrarVehiculoBaseDatos enElRuntConLosDatos() {
    return instrumented(RegistrarVehiculoBaseDatos.class);
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
