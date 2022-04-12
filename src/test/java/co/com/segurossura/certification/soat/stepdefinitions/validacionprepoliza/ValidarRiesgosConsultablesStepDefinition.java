package co.com.segurossura.certification.soat.stepdefinitions.validacionprepoliza;

import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError.MENSAJE_RESPUESTA_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.validacionprepoliza.DetalleRespuestaErrorValidacionPrepoliza;
import co.com.segurossura.certification.soat.tasks.MarcarRiesgoConsultable;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.RegistrarVehiculoBaseDatos;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarDatosRequestPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.validacionprepoliza.ValidarPrepoliza;
import co.com.segurossura.certification.soat.utils.enums.EnumMensajesError;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

public class ValidarRiesgosConsultablesStepDefinition {

  @Dado("que el tomador es un {string} con codigo {string} quiere adquirir el {string}")
  public void marcarRiesgoConsultable(
      String tipoRiesgo, String codigoCausal, String claseVehiculo) {
    theActorInTheSpotlight().attemptsTo(MarcarRiesgoConsultable.conDatos(codigoCausal));
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    theActorInTheSpotlight().attemptsTo(RegistrarVehiculoBaseDatos.enElRuntConLosDatos());
    theActorInTheSpotlight().attemptsTo(AgregarDatosRequestPoliza.conTipoRiesgo(tipoRiesgo));
  }

  @Cuando("el usuario valide el SOAT con Sura")
  public void validarPrepolizaSoat() {
    theActorInTheSpotlight().attemptsTo(ValidarPrepoliza.conLosDatos());
  }

  @Entonces(
      "deberia ver un mensaje indicando que no se puede gestionar el SOAT debido a que es un riesgo alto")
  public void validarMensajeErrorPrepoliza() {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_CONFLICT))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO),
            seeThat(
                    DetalleRespuestaErrorValidacionPrepoliza.deLaValidacion(
                        SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    equalTo(EnumMensajesError.NIVEL_RIESGO_CLIENTE.getMensajesError()))
                .orComplainWith(MensajeRespuestaError.class, MENSAJE_RESPUESTA_ERROR));
  }
}
