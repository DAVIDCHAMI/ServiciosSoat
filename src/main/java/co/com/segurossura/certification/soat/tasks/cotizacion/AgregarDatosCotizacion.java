package co.com.segurossura.certification.soat.tasks.cotizacion;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.REQUEST_COTIZACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.models.builder.RequestCotizacionBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class AgregarDatosCotizacion implements Task, CanBeSilent {

  private final String placaVehiculo;
  private final Map<String, String> mapCaracteristicasVehiculo = new LinkedHashMap<>();

  public AgregarDatosCotizacion(String placaVehiculo) {
    this.placaVehiculo = placaVehiculo;
  }

  public AgregarDatosCotizacion(
      String placaVehiculo, Map<String, String> mapCaracteristicasVehiculo) {
    this.placaVehiculo = placaVehiculo;
    this.mapCaracteristicasVehiculo.putAll(mapCaracteristicasVehiculo);
  }

  public static Performable conLaPlaca(String placaVehiculo) {
    return instrumented(AgregarDatosCotizacion.class, placaVehiculo);
  }

  public static Performable conLosDatos(
      String placaVehiculo, Map<String, String> mapCaracteristicasVehiculo) {
    return instrumented(AgregarDatosCotizacion.class, placaVehiculo, mapCaracteristicasVehiculo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(
        REQUEST_COTIZACION.getVariableSesion(),
        RequestCotizacionBuilder.conLosDatos(placaVehiculo, mapCaracteristicasVehiculo));
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
