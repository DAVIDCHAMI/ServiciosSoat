package co.com.segurossura.certification.soat.models.builder.expedicion;

import static co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv.DATOS_PERSONA;

import co.com.segurossura.certification.soat.models.comunes.Persona;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import java.util.Map;

public final class TomadorBuilder {

  private TomadorBuilder() {}

  public static Persona conLosDatos(String idFiltro) {
    Map<String, String> mapaDatosTomador =
        UtilidadesCsv.obtenerPrimerDatoPrueba(DATOS_PERSONA.getNombre(), idFiltro);
    return Persona.builder()
        .celular(mapaDatosTomador.get("celular"))
        .direccion(mapaDatosTomador.get("direccion"))
        .email(mapaDatosTomador.get("email"))
        .fechaNacimiento(mapaDatosTomador.get("fechaNacimiento"))
        .idCiudad(mapaDatosTomador.get("idCiudad"))
        .idDepartamento(mapaDatosTomador.get("idDepartamento"))
        .naturalezaJuridica(mapaDatosTomador.get("naturalezaJuridica"))
        .numeroDocumento(mapaDatosTomador.get("numeroDocumentoTomador"))
        .primerApellido(mapaDatosTomador.get("primerApellido"))
        .primerNombre(mapaDatosTomador.get("primerNombre"))
        .razonSocial(mapaDatosTomador.get("razonSocial"))
        .segundoApellido(mapaDatosTomador.get("segundoApellido"))
        .segundoNombre(mapaDatosTomador.get("segundoNombre"))
        .tipoDocumento(mapaDatosTomador.get("tipoDocumento"))
        .build();
  }
}
