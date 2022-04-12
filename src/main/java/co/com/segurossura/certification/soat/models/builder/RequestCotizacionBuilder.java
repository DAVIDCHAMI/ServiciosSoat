package co.com.segurossura.certification.soat.models.builder;

import co.com.segurossura.certification.soat.models.cotizacion.RequestCotizacionSoat;
import java.util.Map;

public final class RequestCotizacionBuilder {

  private static final String CANAL_BANCOLOMBIA = "346";

  private RequestCotizacionBuilder() {}

  public static RequestCotizacionSoat conLosDatos(
      String placaVehiculo, Map<String, String> mapCaracteristicasVehiculo) {
    if (mapCaracteristicasVehiculo.isEmpty()) {
      return construirRequestAtributosObligatorios(placaVehiculo);
    } else {
      return construirRequestAtributosAdicionales(placaVehiculo, mapCaracteristicasVehiculo);
    }
  }

  private static RequestCotizacionSoat construirRequestAtributosObligatorios(String placaVehiculo) {
    return RequestCotizacionSoat.builder().canal(CANAL_BANCOLOMBIA).placa(placaVehiculo).build();
  }

  private static RequestCotizacionSoat construirRequestAtributosAdicionales(
      String placaVehiculo, Map<String, String> mapCaracteristicasVehiculo) {
    return RequestCotizacionSoat.builder()
        .canal(CANAL_BANCOLOMBIA)
        .placa(placaVehiculo)
        .datosErradosRunt(DatosErradosRuntBuilder.conLosDatos(mapCaracteristicasVehiculo))
        .build();
  }
}
