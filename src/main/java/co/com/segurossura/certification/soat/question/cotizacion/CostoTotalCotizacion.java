package co.com.segurossura.certification.soat.question.cotizacion;

import co.com.segurossura.certification.soat.models.cotizacion.ResponseCotizacionSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CostoTotalCotizacion implements Question<Float> {

  private final ResponseCotizacionSoat responseCotizacionSoat;

  public CostoTotalCotizacion(ResponseCotizacionSoat responseCotizacionSoat) {
    this.responseCotizacionSoat = responseCotizacionSoat;
  }

  public static CostoTotalCotizacion delSoat(ResponseCotizacionSoat responseCotizacionSoat) {
    return new CostoTotalCotizacion(responseCotizacionSoat);
  }

  @Override
  public Float answeredBy(Actor actor) {
    return responseCotizacionSoat.getTarifa().getCostoTotal();
  }
}
