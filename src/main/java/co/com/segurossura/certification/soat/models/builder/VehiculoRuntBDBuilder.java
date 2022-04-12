package co.com.segurossura.certification.soat.models.builder;

import co.com.segurossura.certification.soat.models.comunes.VehiculoRuntBD;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv;
import java.util.Map;

public final class VehiculoRuntBDBuilder {

  private VehiculoRuntBDBuilder() {}

  public static VehiculoRuntBD construirVehiculoRuntBD(String idFiltro) {
    Map<String, String> mapCaracteristicasVehiculo =
        UtilidadesCsv.obtenerPrimerDatoPrueba(
            EnumNombresCsv.CARACTERISTICAS_VEHICULO.getNombre(), idFiltro);
    return VehiculoRuntBD.builder()
        .idTipoServicio(mapCaracteristicasVehiculo.get("idTipoServicio"))
        .idClaseVehiculo(mapCaracteristicasVehiculo.get("idClaseVehiculo"))
        .idMarca(mapCaracteristicasVehiculo.get("idMarca"))
        .idLinea(mapCaracteristicasVehiculo.get("idLinea"))
        .modelo(mapCaracteristicasVehiculo.get("modelo"))
        .noMotor(mapCaracteristicasVehiculo.get("noMotor"))
        .noChasis(mapCaracteristicasVehiculo.get("noChasis"))
        .noVin(mapCaracteristicasVehiculo.get("noVin"))
        .cilindraje(mapCaracteristicasVehiculo.get("cilindraje"))
        .noPlaca(mapCaracteristicasVehiculo.get("noPlaca"))
        .capacidadPasajerosSentados(mapCaracteristicasVehiculo.get("capacidadPasajerosSentados"))
        .datosTecnicos(
            DatosTecnicosBuilder.construirDatosTecnicosVehiculo(
                mapCaracteristicasVehiculo.get("datosTecnicos")))
        .build();
  }
}
