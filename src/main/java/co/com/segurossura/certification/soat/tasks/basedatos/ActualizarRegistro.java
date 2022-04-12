package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumColumna.VALOR_PARAMETRO;
import static co.com.segurossura.certification.soat.utils.enums.EnumSentenciasSQL.ACTUALIZAR_REGISTRO;
import static co.com.segurossura.certification.soat.utils.enums.EnumTabla.TABLA_PARAMETRIZACION_CANAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public final class ActualizarRegistro {

  private ActualizarRegistro() {}

  public static void parametroDinamico() {
    theActorInTheSpotlight()
        .attemptsTo(
            ActualizarRegistroBaseDatos.conLosDatos(
                ACTUALIZAR_REGISTRO.getSentencia(),
                TABLA_PARAMETRIZACION_CANAL.getTabla(),
                VALOR_PARAMETRO.getColumna(),
                "6"));
  }
}
