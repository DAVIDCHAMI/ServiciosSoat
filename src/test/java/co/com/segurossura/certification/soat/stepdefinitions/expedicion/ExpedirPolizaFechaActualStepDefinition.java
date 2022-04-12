package co.com.segurossura.certification.soat.stepdefinitions.expedicion;

import static co.com.segurossura.certification.soat.exceptions.CodigoEstadoError.CODIGO_ESTADO_ERROR;
import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError.MENSAJE_RESPUESTA_ERROR;
import static co.com.segurossura.certification.soat.utils.enums.EnumCodigoEstado.ESTADO_DATOS_ERRADOS_USUARIO;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajesError.MENSAJE_ERROR_EXPEDICION_SOAT_CON_FECHA_ACTUAL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.CodigoEstadoError;
import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoEstado;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.comunes.ListaMensajesDatosErradosPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarInicioVigencia;
import co.com.segurossura.certification.soat.tasks.expedicion.ExpedirPoliza;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

public class ExpedirPolizaFechaActualStepDefinition {

  @Cuando("el cliente expide el Soat con inicio de vigencia {string}")
  public void expedirSoat(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(AgregarInicioVigencia.conFecha(fechaInicioVigencia));
    theActorInTheSpotlight().attemptsTo(ExpedirPoliza.paraElVehiculo());
  }

  @Entonces("debería ver un mensaje indicando que la fecha debe ser mayor al dia de hoy")
  public void validarMensajeError() {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO));
    theActorInTheSpotlight()
        .should(
            seeThat(
                    CodigoEstado.obtenido(SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    equalTo(ESTADO_DATOS_ERRADOS_USUARIO.getCodigoEstado()))
                .orComplainWith(CodigoEstadoError.class, CODIGO_ESTADO_ERROR),
            seeThat(
                    ListaMensajesDatosErradosPoliza.obtenido(
                        SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    contains(MENSAJE_ERROR_EXPEDICION_SOAT_CON_FECHA_ACTUAL.getMensajesError()))
                .orComplainWith(MensajeRespuestaError.class, MENSAJE_RESPUESTA_ERROR));
  }
}
