package co.com.segurossura.certification.soat.models.builder.expedicion;

import static co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv.DATOS_PERSONA;

import co.com.segurossura.certification.soat.models.comunes.Persona;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import java.util.Map;

public final class PropietarioBuilder {

  private PropietarioBuilder() {}

  public static Persona conLosDatos(String idFiltro) {
    Map<String, String> mapaDatosPropietario =
        UtilidadesCsv.obtenerPrimerDatoPrueba(DATOS_PERSONA.getNombre(), idFiltro);
    return Persona.builder()
        .numeroDocumento(mapaDatosPropietario.get("numeroDocumentoPropietario"))
        .primerApellido(mapaDatosPropietario.get("primerApellido"))
        .primerNombre(mapaDatosPropietario.get("primerNombre"))
        .razonSocial(mapaDatosPropietario.get("razonSocial"))
        .segundoApellido(mapaDatosPropietario.get("segundoApellido"))
        .segundoNombre(mapaDatosPropietario.get("segundoNombre"))
        .tipoDocumento(mapaDatosPropietario.get("tipoDocumento"))
        .build();
  }
}
