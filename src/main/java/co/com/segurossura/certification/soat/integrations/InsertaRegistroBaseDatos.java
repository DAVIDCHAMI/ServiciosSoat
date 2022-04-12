package co.com.segurossura.certification.soat.integrations;

import static co.com.segurossura.certification.soat.utils.RutaBundle.INSERTAR_BASE_DATOS;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import co.com.segurossura.certification.soat.utils.Logger;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.SneakyThrows;

public final class InsertaRegistroBaseDatos {

  private static Statement declararInsercion;

  private InsertaRegistroBaseDatos() {}

  @SneakyThrows
  public static void insertarRegistroBD(Parametros parametros) {

    try {
      declararInsercion = ConectarseALaBaseDeDatos.getConexion().createStatement();
      declararInsercion.executeUpdate(
          String.format(
              INSERTAR_BASE_DATOS.getString(parametros.getBundle()),
              parametros.getTabla(),
              parametros.getColumna(),
              parametros.getDato()));
      Logger.info(
          "InsertaRegistroBaseDatos",
          String.format(
              "El registro '%s' se insertó correctamente en la tabla '%s'",
              parametros.getDato(), parametros.getTabla()));
      declararInsercion.close();
    } catch (SQLException ex) {
      Logger.error(
          "InsertaRegistroBaseDatos",
          String.format(
              "No se pudo insertar el registro '%s' de la tabla '%s', con la excepción '%s'",
              parametros.getDato(), parametros.getTabla(), ex));
    } finally {
      declararInsercion.close();
    }
  }
}
