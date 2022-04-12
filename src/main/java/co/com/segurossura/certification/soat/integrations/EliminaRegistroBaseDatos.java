package co.com.segurossura.certification.soat.integrations;

import static co.com.segurossura.certification.soat.utils.RutaBundle.ELIMINAR_BASE_DATOS;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import co.com.segurossura.certification.soat.utils.Logger;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.SneakyThrows;

public final class EliminaRegistroBaseDatos {

  private static Statement declararEliminacion;

  private EliminaRegistroBaseDatos() {}

  @SneakyThrows
  public static void eliminarRegistroBD(Parametros parametros) {
    try {
      declararEliminacion = ConectarseALaBaseDeDatos.getConexion().createStatement();
      if (parametros.getDato() != null) {
        String query =
            String.format(
                ELIMINAR_BASE_DATOS.getString(parametros.getBundle()),
                parametros.getTabla(),
                parametros.getColumna(),
                parametros.getDato());
        declararEliminacion.executeQuery(query);
        Logger.info(
            "EliminaRegistroBaseDatos",
            String.format(
                "El registro '%s' se eliminó correctamente de la tabla '%s'",
                parametros.getDato(), parametros.getTabla()));
      }
    } catch (SQLException ex) {
      Logger.error(
          "EliminaRegistroBaseDatos",
          String.format(
              "No se pudo eliminar el registro '%s' de la tabla '%s', con la excepción '%s'",
              parametros.getDato(), parametros.getTabla(), ex));
    } finally {
      declararEliminacion.close();
    }
  }
}
