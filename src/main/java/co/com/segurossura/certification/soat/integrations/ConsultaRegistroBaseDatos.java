package co.com.segurossura.certification.soat.integrations;

import static co.com.segurossura.certification.soat.utils.RutaBundle.CONSULTAR_BASE_DATOS;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import co.com.segurossura.certification.soat.utils.Logger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;

public final class ConsultaRegistroBaseDatos {

  private static Statement declararConsulta;

  private ConsultaRegistroBaseDatos() {}

  @SneakyThrows
  public static List<Map<String, String>> consultaRegistroBaseDatos(Parametros parametros) {
    List<Map<String, String>> listaMapasConsulta = new ArrayList<>();
    try {
      declararConsulta = ConectarseALaBaseDeDatos.getConexion().createStatement();
      String query =
          String.format(
              CONSULTAR_BASE_DATOS.getString(parametros.getBundle()),
              parametros.getTabla(),
              parametros.getColumna(),
              parametros.getDato());
      ResultSet rs = declararConsulta.executeQuery(query);
      listaMapasConsulta = convertirResulsetLista(rs);
    } catch (SQLException ex) {
      Logger.error(
          "ConsultaRegistroBaseDatos",
          String.format(
              "No se pudo consultar el registro '%s' de la tabla '%s', con la excepción '%s'",
              parametros.getDato(), parametros.getTabla(), ex));
    } finally {
      declararConsulta.close();
    }
    return listaMapasConsulta;
  }

  private static List<Map<String, String>> convertirResulsetLista(ResultSet rs)
      throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    List<Map<String, String>> rows = new ArrayList<>();
    while (rs.next()) {
      Map<String, String> row = new HashMap<>(columns);
      for (int i = 1; i <= columns; ++i) {
        row.put(md.getColumnName(i), String.valueOf(rs.getObject(i)));
      }
      rows.add(row);
    }
    rs.close();
    return rows;
  }
}
