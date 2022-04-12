package co.com.segurossura.certification.soat.question.cotizacion;

import co.com.segurossura.certification.soat.models.cotizacion.ResponseCotizacionSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeRespuestaCotizarSoatConSoatVigente implements Question<String> {
  private final ResponseCotizacionSoat responseCotizacionSoat;

  public MensajeRespuestaCotizarSoatConSoatVigente(ResponseCotizacionSoat responseCotizacionSoat) {
    this.responseCotizacionSoat = responseCotizacionSoat;
  }

  public static MensajeRespuestaCotizarSoatConSoatVigente deLaCotizacion(
      ResponseCotizacionSoat responseCotizacionSoat) {
    return new MensajeRespuestaCotizarSoatConSoatVigente(responseCotizacionSoat);
  }

  @Override
  public String answeredBy(Actor actor) {
    return responseCotizacionSoat.getMessage();
  }
}
