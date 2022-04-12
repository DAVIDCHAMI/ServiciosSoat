package co.com.segurossura.certification.soat.models.builder.expedicion;

import static co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv.DATOS_GENERICOS_REQUEST;

import co.com.segurossura.certification.soat.models.comunes.RequestPolizaSoat;
import co.com.segurossura.certification.soat.utils.Cadenas;
import co.com.segurossura.certification.soat.utils.Fechas;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import co.com.segurossura.certification.soat.utils.enums.EnumSeparadores;
import java.util.Map;

public final class RequestExpedicionBuilder {

  private RequestExpedicionBuilder() {}

  public static RequestPolizaSoat conLosDatos(String tipoRiesgo, String numeroPlaca) {
    Map<String, String> mapaDatosGenericosRequest =
        UtilidadesCsv.obtenerPrimerDatoPrueba(
            DATOS_GENERICOS_REQUEST.getNombre(),
            Cadenas.concatenarCadenas(
                EnumSeparadores.SEPARADOR_VIRGULILLA, tipoRiesgo, numeroPlaca));
    return RequestPolizaSoat.builder()
        .codigoAsesor(mapaDatosGenericosRequest.get("codigoAsesor"))
        .direccionIP(mapaDatosGenericosRequest.get("direccionIp"))
        .fechaInicioVigencia(Fechas.adicionarDiasFechaActual(1))
        .placa(numeroPlaca)
        .propietario(PropietarioBuilder.conLosDatos(tipoRiesgo))
        .retroactiva(mapaDatosGenericosRequest.get("retroactiva"))
        .tenant(mapaDatosGenericosRequest.get("tenant"))
        .tomador(TomadorBuilder.conLosDatos(tipoRiesgo))
        .urlRetorno(mapaDatosGenericosRequest.get("urlRetorno"))
        .build();
  }
}
