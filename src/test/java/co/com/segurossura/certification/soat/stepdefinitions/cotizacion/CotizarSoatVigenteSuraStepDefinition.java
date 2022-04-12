package co.com.segurossura.certification.soat.stepdefinitions.cotizacion;

import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError.MENSAJE_RESPUESTA_ERROR;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajesError.MENSAJE_ERROR_COTIZACION_SOAT_CON_SOAT_VIGENTE;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.MensajeRespuestaError;
import co.com.segurossura.certification.soat.models.cotizacion.ResponseCotizacionSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.cotizacion.MensajeRespuestaCotizarSoatConSoatVigente;
import co.com.segurossura.certification.soat.tasks.basedatos.ActualizarParametroDinamico;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.RegistrarVehiculoBaseDatos;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarDatosRequestPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.cotizacion.AgregarDatosCotizacion;
import co.com.segurossura.certification.soat.tasks.cotizacion.CotizarSoat;
import co.com.segurossura.certification.soat.tasks.expedicion.ExpedirPoliza;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

public class CotizarSoatVigenteSuraStepDefinition {
  @Dado("que una persona {string} tiene un {string}")
  public void registrarVehiculoRunt(String tipoRiesgo, String soatVigente) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(soatVigente));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    theActorInTheSpotlight().attemptsTo(RegistrarVehiculoBaseDatos.enElRuntConLosDatos());
    theActorInTheSpotlight().attemptsTo(AgregarDatosRequestPoliza.conTipoRiesgo(tipoRiesgo));
    theActorInTheSpotlight().attemptsTo(ExpedirPoliza.paraElVehiculo());
    theActorInTheSpotlight().attemptsTo(ActualizarParametroDinamico.conLosDatos());
  }

  @Cuando("el usuario cotiza el valor del SOAT")
  public void cotizaSOATErroneamente() {
    theActorInTheSpotlight()
        .attemptsTo(
            AgregarDatosCotizacion.conLaPlaca(
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
    theActorInTheSpotlight().attemptsTo(CotizarSoat.paraElVehiculo());
  }

  @Entonces("debería ver un mensaje indicando que se tiene un SOAT vigente con Sura")
  public void validarMensajeRespuestaError() {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(409))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO));
    theActorInTheSpotlight()
        .should(
            seeThat(
                    MensajeRespuestaCotizarSoatConSoatVigente.deLaCotizacion(
                        SerenityRest.lastResponse().as(ResponseCotizacionSoat.class)),
                    equalTo(MENSAJE_ERROR_COTIZACION_SOAT_CON_SOAT_VIGENTE.getMensajesError()))
                .orComplainWith(MensajeRespuestaError.class, MENSAJE_RESPUESTA_ERROR));
  }
}
