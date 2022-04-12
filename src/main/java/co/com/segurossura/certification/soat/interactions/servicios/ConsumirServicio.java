package co.com.segurossura.certification.soat.interactions.servicios;

import co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios;
import java.util.Map;

public final class ConsumirServicio {

  private ConsumirServicio() {}

  public static ConsumirServicioGetSimple getSimple(
      String recurso, EnumCredencialesServicios enumCredenciales) {
    return new ConsumirServicioGetSimple(recurso, enumCredenciales);
  }

  public static ConsumirServicioPostSimple postSimple(
      String recurso, EnumCredencialesServicios enumCredenciales, Object request) {
    return new ConsumirServicioPostSimple(recurso, enumCredenciales, request);
  }

  public static ConsumirServicioPostConHeaders postConHeaders(
      String recurso,
      EnumCredencialesServicios enumCredenciales,
      Object request,
      Map<String, ?> headers) {
    return new ConsumirServicioPostConHeaders(recurso, enumCredenciales, request, headers);
  }

  public static ConsumirServicioSoapConHeaders soapConHeaders(
      String recurso,
      EnumCredencialesServicios enumCredencialesServicios,
      Object request,
      Map<String, ?> headers1,
      Map<String, ?> headers2,
      Map<String, ?> headers3) {
    return new ConsumirServicioSoapConHeaders(
        recurso, enumCredencialesServicios, request, headers1, headers2, headers3);
  }
}
