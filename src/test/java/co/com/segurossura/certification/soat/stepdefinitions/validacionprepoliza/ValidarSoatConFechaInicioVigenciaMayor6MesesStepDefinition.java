package co.com.segurossura.certification.soat.stepdefinitions.validacionprepoliza;

import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError.MENSAJE_RESPUESTA_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.validacionprepoliza.MensajeRespuestaErrorValidacionPrepoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.ActualizarParametroDinamico;
import co.com.segurossura.certification.soat.tasks.basedatos.RegistrarVehiculoBaseDatos;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarDatosRequestPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.expedicion.ExpedirPoliza;
import co.com.segurossura.certification.soat.tasks.validacionprepoliza.ValidarPrepoliza;
import co.com.segurossura.certification.soat.utils.enums.EnumMensajesError;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

public class ValidarSoatConFechaInicioVigenciaMayor6MesesStepDefinition {
  @Dado("que una persona {string} tiene un {string} con sura")
  public void crearExpedicion(String tipoRiesgo, String claseVehiculo) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(RegistrarVehiculoBaseDatos.enElRuntConLosDatos());
    theActorInTheSpotlight().attemptsTo(AgregarDatosRequestPoliza.conTipoRiesgo(tipoRiesgo));
    theActorInTheSpotlight().attemptsTo(ExpedirPoliza.paraElVehiculo());
    theActorInTheSpotlight().attemptsTo(ActualizarParametroDinamico.conLosDatos());
  }

  @Cuando("el usuario intente validar el soat vigente")
  public void validarPrepoliza() {
    theActorInTheSpotlight().attemptsTo(ValidarPrepoliza.conLosDatos());
  }

  @Entonces(
      "debería ver un mensaje indicando que tiene un Soat vigente con una fecha vencimiento mayor a seis meses")
  public void validarRespuestaMensajes() {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_CONFLICT))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO),
            seeThat(
                    MensajeRespuestaErrorValidacionPrepoliza.deLaValidacion(
                        SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    equalTo(
                        EnumMensajesError.MENSAJE_ERROR_SOAT_FECHA_VENCIMIENTO_MAYOR_6_MESES
                            .getMensajesError()))
                .orComplainWith(MensajeRespuestaError.class, MENSAJE_RESPUESTA_ERROR));
  }
}
