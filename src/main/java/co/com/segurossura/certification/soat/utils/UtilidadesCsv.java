package co.com.segurossura.certification.soat.utils;

import static co.com.segurossura.certification.soat.utils.enums.EnumConstantesCsv.EXTENSION_NOMBRE_DATOS_CSV;
import static co.com.segurossura.certification.soat.utils.enums.EnumConstantesCsv.NOMBRE_COLUMNA_FILTRO;
import static co.com.segurossura.certification.soat.utils.enums.EnumConstantesCsv.PREFIJO_NOMBRE_DATOS_CSV;
import static co.com.segurossura.certification.soat.utils.enums.EnumConstantesCsv.RUTA_RECURSOS_DATOS_CSV;
import static co.com.segurossura.certification.soat.utils.enums.EnumSeparadores.SEPARADOR_COMA;
import static co.com.segurossura.certification.soat.utils.enums.EnumSeparadores.SEPARADOR_PUNTO_COMA;

import co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

public final class UtilidadesCsv {

  private UtilidadesCsv() {}

  public static Map<String, String> obtenerPrimerDatoPrueba(String nombreCsv, String filtro) {
    try {
      return obtenerDatosPrueba(nombreCsv, filtro).get(0);
    } catch (IndexOutOfBoundsException ex) {
      Logger.error(
          "UtilidadesCsv",
          String.format(
              "No se pudo consultar datos del archivo '%s' con filtro '%s'. Se muestra la excepción '%s'",
              nombreCsv, filtro, ex));
      throw new IndexOutOfBoundsException();
    }
  }

  @SneakyThrows
  public static List<Map<String, String>> obtenerDatosPrueba(String nombreCsv, String filtro) {
    String rutaCsv =
        Cadenas.concatenarCadenas(
            RUTA_RECURSOS_DATOS_CSV.getConstanteCsv(),
            PREFIJO_NOMBRE_DATOS_CSV.getConstanteCsv(),
            nombreCsv,
            EXTENSION_NOMBRE_DATOS_CSV.getConstanteCsv());
    TestDataSource datosOrigenCsv =
        new CSVTestDataSource(rutaCsv, SEPARADOR_PUNTO_COMA.getSeparador().charAt(0));
    return obtenerDatosFiltrados(datosOrigenCsv, filtro);
  }

  private static List<Map<String, String>> obtenerDatosFiltrados(
      TestDataSource datosCsv, String cadenaListadoFiltros) {
    List<Map<String, String>> lstTotalDatosCsv = datosCsv.getData();
    if ("".equals(cadenaListadoFiltros)) {
      return lstTotalDatosCsv;
    }
    String[] arrListadoFiltros = cadenaListadoFiltros.split(SEPARADOR_COMA.getSeparador());
    return filtrarDatos(arrListadoFiltros, lstTotalDatosCsv);
  }

  private static List<Map<String, String>> filtrarDatos(
      String[] arrListaFiltros, List<Map<String, String>> lstTotalDatos) {
    return lstTotalDatos
        .stream()
        .filter(fila -> inArray(arrListaFiltros, fila.get(NOMBRE_COLUMNA_FILTRO.getConstanteCsv())))
        .collect(Collectors.toList());
  }

  private static boolean inArray(String[] arr, String item) {
    if (arr.length > 0) {
      for (String n : arr) {
        if (item.trim().equals(n.trim())) {
          return true;
        }
      }
    }
    return false;
  }

  public static String obtenerDatoContenidoCsv(
      EnumNombresCsv nombreDiccionarioCsv,
      String nombreColumnaPivote,
      String valorColumnaPivote,
      String nombreColumnaRetornar) {
    List<Map<String, String>> lstDiccionario =
        obtenerDatosPrueba(nombreDiccionarioCsv.getNombre(), valorColumnaPivote);
    Optional<String> valorObtenido =
        lstDiccionario
            .stream()
            .filter(registro -> valorColumnaPivote.equals(registro.get(nombreColumnaPivote)))
            .map(registro -> registro.get(nombreColumnaRetornar))
            .findFirst();
    if (valorObtenido.isPresent()) {
      return valorObtenido.get();
    }
    throw new IllegalArgumentException(
        String.format("Columna %s NO encontrada", nombreColumnaRetornar));
  }
}
