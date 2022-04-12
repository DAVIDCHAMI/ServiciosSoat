package co.com.segurossura.certification.soat.question.cotizacion;

import co.com.segurossura.certification.soat.models.cotizacion.ResponseCotizacionSoat;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ListaErroresVehiculo implements Question<List<String>> {

  private final ResponseCotizacionSoat responseCotizacionSoat;

  public ListaErroresVehiculo(ResponseCotizacionSoat responseCotizacionSoat) {
    this.responseCotizacionSoat = responseCotizacionSoat;
  }

  public static ListaErroresVehiculo obtenida(ResponseCotizacionSoat responseCotizacionSoat) {
    return new ListaErroresVehiculo(responseCotizacionSoat);
  }

  @Override
  public List<String> answeredBy(Actor actor) {
    List<String> lstErroresVehiculo = new ArrayList<>();
    responseCotizacionSoat
        .getDatosErradosVehiculo()
        .forEach(
            datosErradosVehiculo ->
                lstErroresVehiculo.addAll(datosErradosVehiculo.getDescripcionError()));
    return lstErroresVehiculo;
  }
}
