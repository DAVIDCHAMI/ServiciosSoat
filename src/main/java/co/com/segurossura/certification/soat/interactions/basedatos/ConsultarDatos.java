package co.com.segurossura.certification.soat.interactions.basedatos;

import static co.com.segurossura.certification.soat.integrations.ConsultaRegistroBaseDatos.consultaRegistroBaseDatos;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RETORNO_CONSULTA_BD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsultarDatos implements Interaction, CanBeSilent {

  private final Parametros parametros;

  public ConsultarDatos(Parametros parametros) {
    this.parametros = parametros;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(RETORNO_CONSULTA_BD.getVariableSesion(), consultaRegistroBaseDatos(parametros));
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static ConsultarDatos conLosParametros(Parametros parametros) {
    return instrumented(ConsultarDatos.class, parametros);
  }
}
