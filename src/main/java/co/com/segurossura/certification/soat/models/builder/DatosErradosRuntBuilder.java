package co.com.segurossura.certification.soat.models.builder;

import co.com.segurossura.certification.soat.models.cotizacion.DatosErradosRunt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DatosErradosRuntBuilder {

  private static final String NO_APLICA = "N/A";

  private DatosErradosRuntBuilder() {}

  public static List<DatosErradosRunt> conLosDatos(Map<String, String> mapCaracteristicasVehiculo) {
    List<DatosErradosRunt> lstDatosErradosRunt = new ArrayList<>();
    limpiarCaracteristicasVehiculoNoAplicadas(mapCaracteristicasVehiculo);
    mapCaracteristicasVehiculo.forEach(
        (dato, valor) ->
            lstDatosErradosRunt.add(DatosErradosRunt.builder().dato(dato).valor(valor).build()));
    return lstDatosErradosRunt;
  }

  private static void limpiarCaracteristicasVehiculoNoAplicadas(
      Map<String, String> mapCaracteristicasVehiculo) {
    mapCaracteristicasVehiculo
        .entrySet()
        .removeIf(elementoMapa -> elementoMapa.getValue().equals(NO_APLICA));
  }
}
