package co.com.segurossura.certification.soat.stepdefinitions.validacionprepoliza;

import static co.com.segurossura.certification.soat.exceptions.CodigoEstadoError.CODIGO_ESTADO_ERROR;
import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError.MENSAJE_RESPUESTA_ERROR;
import static co.com.segurossura.certification.soat.exceptions.ValorTarifaError.VALOR_TARIFA_ERRADO;
import static co.com.segurossura.certification.soat.utils.Fechas.agregarDiasFechaIngresada;
import static co.com.segurossura.certification.soat.utils.Fechas.fechaVigenciaSoat;
import static co.com.segurossura.certification.soat.utils.enums.EnumCodigoEstado.ESTADO_DATOS_ERRADOS_USUARIO;
import static co.com.segurossura.certification.soat.utils.enums.EnumCodigoEstado.ESTADO_OK;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajesError.VALIDACION_SOAT_VIGENTE;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.FECHA_FIN_VIGENCIA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import co.com.segurossura.certification.soat.exceptions.CodigoEstadoError;
import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError;
import co.com.segurossura.certification.soat.exceptions.ValorTarifaError;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoEstado;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.comunes.ListaMensajesDatosErradosPoliza;
import co.com.segurossura.certification.soat.question.comunes.ValorTarifaExpedicion;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarInicioVigencia;
import co.com.segurossura.certification.soat.tasks.expedicion.ExpedirPoliza;
import co.com.segurossura.certification.soat.tasks.validacionprepoliza.ValidarPrepoliza;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

public class ValidarPrepolizaStepDefinition {

  @Y("tiene un soat con fecha de inicio de vigencia {string}")
  public void expedirSoat(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(AgregarInicioVigencia.conFecha(fechaInicioVigencia));
    theActorInTheSpotlight()
        .remember(
            FECHA_FIN_VIGENCIA.getVariableSesion(),
            agregarDiasFechaIngresada(fechaVigenciaSoat(fechaInicioVigencia)));
    theActorInTheSpotlight().attemptsTo(ExpedirPoliza.paraElVehiculo());
  }

  @Cuando("el cliente valide el soat con fecha de inicio de vigencia {string}")
  public void validarSoat(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(AgregarInicioVigencia.conFecha(fechaInicioVigencia));
    theActorInTheSpotlight().attemptsTo(ValidarPrepoliza.conLosDatos());
  }

  @Entonces("debería ver un mensaje de error indicando que ya tiene un Soat vigente")
  public void verificarMensajeError() {
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
                    hasItem(
                        VALIDACION_SOAT_VIGENTE.getMensajesError()
                            + theActorInTheSpotlight()
                                .recall(FECHA_FIN_VIGENCIA.getVariableSesion())))
                .orComplainWith(MensajeRespuestaError.class, MENSAJE_RESPUESTA_ERROR));
  }

  @Entonces("debería ver que la tarifa del SOAT es {float}")
  public void verificarTarifaPrePoliza(float tarifaSoat) {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO));
    theActorInTheSpotlight()
        .should(
            seeThat(
                    CodigoEstado.obtenido(SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    equalTo(ESTADO_OK.getCodigoEstado()))
                .orComplainWith(CodigoEstadoError.class, CODIGO_ESTADO_ERROR),
            seeThat(
                    ValorTarifaExpedicion.obtenido(
                        SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    equalTo(tarifaSoat))
                .orComplainWith(ValorTarifaError.class, VALOR_TARIFA_ERRADO));
  }
}
