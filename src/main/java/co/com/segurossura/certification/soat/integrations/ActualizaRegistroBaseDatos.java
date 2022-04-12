package co.com.segurossura.certification.soat.integrations;

import static co.com.segurossura.certification.soat.utils.RutaBundle.ACTUALIZAR_BASE_DATOS;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import co.com.segurossura.certification.soat.utils.Logger;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.SneakyThrows;

public final class ActualizaRegistroBaseDatos {

  private static Statement declararActualizacion;

  private ActualizaRegistroBaseDatos() {}

  @SneakyThrows
  public static void actualizarRegistroBD(Parametros parametros) {

    try {
      declararActualizacion = ConectarseALaBaseDeDatos.getConexion().createStatement();
      declararActualizacion.executeUpdate(
          String.format(
              ACTUALIZAR_BASE_DATOS.getString(parametros.getBundle()),
              parametros.getTabla(),
              parametros.getColumna(),
              parametros.getDato()));
      Logger.info(
          "ActualizarRegistroBaseDatos",
          String.format(
              "El registro '%s' se actualizo correctamente en la tabla '%s'",
              parametros.getDato(), parametros.getTabla()));
      declararActualizacion.close();
    } catch (SQLException ex) {
      Logger.error(
          "ActualizarRegistroBaseDatos",
          String.format(
              "No se pudo actualizar el registro '%s' de la tabla '%s', con la excepción '%s'",
              parametros.getDato(), parametros.getTabla(), ex));
    } finally {
      declararActualizacion.close();
    }
  }
}
