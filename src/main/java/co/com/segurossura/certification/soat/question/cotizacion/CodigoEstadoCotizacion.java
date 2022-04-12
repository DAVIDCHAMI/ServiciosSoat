package co.com.segurossura.certification.soat.question.cotizacion;

import co.com.segurossura.certification.soat.models.cotizacion.ResponseCotizacionSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoEstadoCotizacion implements Question<String> {

  private final ResponseCotizacionSoat responseCotizacionSoat;

  public CodigoEstadoCotizacion(ResponseCotizacionSoat responseCotizacionSoat) {
    this.responseCotizacionSoat = responseCotizacionSoat;
  }

  public static CodigoEstadoCotizacion obtenido(ResponseCotizacionSoat responseCotizacionSoat) {
    return new CodigoEstadoCotizacion(responseCotizacionSoat);
  }

  @Override
  public String answeredBy(Actor actor) {
    return responseCotizacionSoat.getCodigoEstado();
  }
}
