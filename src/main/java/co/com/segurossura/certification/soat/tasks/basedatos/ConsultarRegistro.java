package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumColumna.NUMERO_PLACA;
import static co.com.segurossura.certification.soat.utils.enums.EnumSentenciasSQL.CONSULTAR_REGISTRO_NUMERO_POLIZA;
import static co.com.segurossura.certification.soat.utils.enums.EnumTabla.TABLA_SOAT_POLIZAS;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public final class ConsultarRegistro {

  private ConsultarRegistro() {}

  public static void numeroPoliza() {
    theActorInTheSpotlight()
        .attemptsTo(
            ConsultarRegistroBaseDatos.conLosDatos(
                CONSULTAR_REGISTRO_NUMERO_POLIZA.getSentencia(),
                TABLA_SOAT_POLIZAS.getTabla(),
                NUMERO_PLACA.getColumna(),
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
  }
}
