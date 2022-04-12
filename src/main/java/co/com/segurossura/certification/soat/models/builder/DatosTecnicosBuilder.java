package co.com.segurossura.certification.soat.models.builder;

import co.com.segurossura.certification.soat.models.comunes.DatosTecnicos;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv;
import java.util.Map;

public final class DatosTecnicosBuilder {

  private DatosTecnicosBuilder() {}

  public static DatosTecnicos construirDatosTecnicosVehiculo(String idFiltro) {
    Map<String, String> mapDatosTecnicos =
        UtilidadesCsv.obtenerPrimerDatoPrueba(EnumNombresCsv.DATOS_TECNICOS.getNombre(), idFiltro);
    return DatosTecnicos.builder()
        .capacidadCarga(mapDatosTecnicos.get("capacidadCarga"))
        .pesoBrutoVehicular(mapDatosTecnicos.get("pesoBrutoVehicular"))
        .idTipoCombustible(mapDatosTecnicos.get("idTipoCombustible"))
        .build();
  }
}
