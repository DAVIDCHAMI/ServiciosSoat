package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CARACTERISTICAS_VEHICULO_JSON;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.models.builder.VehiculoRuntBDBuilder;
import co.com.segurossura.certification.soat.models.comunes.VehiculoRuntBD;
import co.com.segurossura.certification.soat.utils.Cadenas;
import co.com.segurossura.certification.soat.utils.enums.EnumSeparadores;
import java.util.ArrayList;
import java.util.Map;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ObtenerCaracteristicasVehiculo implements Task, CanBeSilent {

  private final String idFiltroCaracteristicasVehiculo;

  public ObtenerCaracteristicasVehiculo(Map<String, String> mapCaracteristicasVehiculo) {
    idFiltroCaracteristicasVehiculo =
        Cadenas.concatenarCadenas(
            EnumSeparadores.SEPARADOR_VIRGULILLA,
            new ArrayList<>(mapCaracteristicasVehiculo.values()));
  }

  public ObtenerCaracteristicasVehiculo(String idFiltroCaracteristicasVehiculo) {
    this.idFiltroCaracteristicasVehiculo = idFiltroCaracteristicasVehiculo;
  }

  public static Performable conLosDatos(Map<String, String> mapCaracteristicasVehiculo) {
    return instrumented(ObtenerCaracteristicasVehiculo.class, mapCaracteristicasVehiculo);
  }

  public static Performable conElFiltro(String idFiltroCaracteristicasVehiculo) {
    return instrumented(ObtenerCaracteristicasVehiculo.class, idFiltroCaracteristicasVehiculo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    VehiculoRuntBD vehiculoRuntBD =
        VehiculoRuntBDBuilder.construirVehiculoRuntBD(idFiltroCaracteristicasVehiculo);
    actor.remember(PLACA_VEHICULO.getVariableSesion(), vehiculoRuntBD.getNoPlaca());
    actor.remember(
        CARACTERISTICAS_VEHICULO_JSON.getVariableSesion(),
        Cadenas.convertirObjetoJsonString(vehiculoRuntBD));
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
