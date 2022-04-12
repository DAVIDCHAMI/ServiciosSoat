package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumColumna.NUMERO_POLIZA;
import static co.com.segurossura.certification.soat.utils.enums.EnumColumna.PLACA_RUNT;
import static co.com.segurossura.certification.soat.utils.enums.EnumSentenciasSQL.ELIMINAR_REGISTRO;
import static co.com.segurossura.certification.soat.utils.enums.EnumTabla.TABLA_CONSUMO_RUNT;
import static co.com.segurossura.certification.soat.utils.enums.EnumTabla.TABLA_SOAT_POLIZAS;
import static co.com.segurossura.certification.soat.utils.enums.EnumTabla.TABLA_SOAT_SIIS;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RESULTADO_CONSULTA_OBTENIDO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public final class EliminarRegistro {

  private EliminarRegistro() {}

  public static void vehiculoRunt() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_CONSUMO_RUNT.getTabla(),
                PLACA_RUNT.getColumna(),
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
  }

  public static void polizaSoat() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_SOAT_POLIZAS.getTabla(),
                NUMERO_POLIZA.getColumna(),
                theActorInTheSpotlight().recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion())));
  }

  public static void polizaSiis() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_SOAT_SIIS.getTabla(),
                NUMERO_POLIZA.getColumna(),
                theActorInTheSpotlight().recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion())));
  }
}
