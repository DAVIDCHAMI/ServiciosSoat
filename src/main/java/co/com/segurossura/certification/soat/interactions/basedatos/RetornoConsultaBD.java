package co.com.segurossura.certification.soat.interactions.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RESULTADO_CONSULTA_OBTENIDO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RETORNO_CONSULTA_BD;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;
import java.util.Map;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class RetornoConsultaBD implements Interaction, CanBeSilent {

  private final int filaRegistro;
  private final String clave;
  List<Map<String, String>> registro =
      theActorInTheSpotlight().recall(RETORNO_CONSULTA_BD.getVariableSesion());

  public RetornoConsultaBD(int filaRegistro, String clave) {
    this.filaRegistro = filaRegistro;
    this.clave = clave;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (!registro.isEmpty()) {
      actor.remember(
          RESULTADO_CONSULTA_OBTENIDO.getVariableSesion(), registro.get(filaRegistro).get(clave));
    }
  }

  public static RetornoConsultaBD conLosDatos(int filaRegistro, String clave) {
    return instrumented(RetornoConsultaBD.class, filaRegistro, clave);
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
