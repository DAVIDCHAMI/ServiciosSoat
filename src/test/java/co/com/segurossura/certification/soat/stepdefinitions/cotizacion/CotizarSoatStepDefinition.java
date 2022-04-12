package co.com.segurossura.certification.soat.stepdefinitions.cotizacion;

import static co.com.segurossura.certification.soat.exceptions.CodigoEstadoError.CODIGO_ESTADO_ERROR;
import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.MensajeInexistenteError.MENSAJE_INEXISTENTE_ERROR;
import static co.com.segurossura.certification.soat.exceptions.ValorTarifaError.VALOR_TARIFA_ERRADO;
import static co.com.segurossura.certification.soat.utils.enums.EnumCodigoEstado.ESTADO_DATOS_ERRADOS_RUNT_Y_USUARIO;
import static co.com.segurossura.certification.soat.utils.enums.EnumCodigoEstado.ESTADO_OK;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import co.com.segurossura.certification.soat.exceptions.CodigoEstadoError;
import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.MensajeInexistenteError;
import co.com.segurossura.certification.soat.exceptions.ValorTarifaError;
import co.com.segurossura.certification.soat.models.cotizacion.ResponseCotizacionSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.cotizacion.CodigoEstadoCotizacion;
import co.com.segurossura.certification.soat.question.cotizacion.CostoTotalCotizacion;
import co.com.segurossura.certification.soat.question.cotizacion.ListaErroresVehiculo;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.RegistrarVehiculoBaseDatos;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.cotizacion.AgregarDatosCotizacion;
import co.com.segurossura.certification.soat.tasks.cotizacion.CotizarSoat;
import co.com.segurossura.certification.soat.utils.Cadenas;
import co.com.segurossura.certification.soat.utils.enums.EnumSeparadores;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

public class CotizarSoatStepDefinition {

  @Dado("que René tiene un vehículo con las siguientes características")
  public void agregarInformacionVehiculo(Map<String, String> mapCaracteristicasVehiculo) {
    theActorInTheSpotlight()
        .attemptsTo(ObtenerCaracteristicasVehiculo.conLosDatos(mapCaracteristicasVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    theActorInTheSpotlight().attemptsTo(RegistrarVehiculoBaseDatos.enElRuntConLosDatos());
  }

  @Cuando("cotice el valor del SOAT")
  public void cotizarSoat() {
    theActorInTheSpotlight()
        .attemptsTo(
            AgregarDatosCotizacion.conLaPlaca(
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
    theActorInTheSpotlight().attemptsTo(CotizarSoat.paraElVehiculo());
  }

  @Cuando("cotice el valor del SOAT agregando los datos")
  public void cotizarSoat(Map<String, String> mapCaracteristicasVehiculo) {
    theActorInTheSpotlight()
        .attemptsTo(
            AgregarDatosCotizacion.conLosDatos(
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion()),
                mapCaracteristicasVehiculo));
    theActorInTheSpotlight().attemptsTo(CotizarSoat.paraElVehiculo());
  }

  @Entonces("debería ver que el costo total del SOAT es igual a {float}")
  public void verificarValorSoat(Float tarifaSoat) {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO));
    theActorInTheSpotlight()
        .should(
            seeThat(
                    CodigoEstadoCotizacion.obtenido(
                        SerenityRest.lastResponse().as(ResponseCotizacionSoat.class)),
                    equalTo(ESTADO_OK.getCodigoEstado()))
                .orComplainWith(CodigoEstadoError.class, CODIGO_ESTADO_ERROR),
            seeThat(
                    CostoTotalCotizacion.delSoat(
                        SerenityRest.lastResponse().as(ResponseCotizacionSoat.class)),
                    equalTo(tarifaSoat))
                .orComplainWith(ValorTarifaError.class, VALOR_TARIFA_ERRADO));
  }

  @Entonces("debería ver los mensajes de error {string}")
  public void verificarMensajeError(String mensajesError) {
    theActorInTheSpotlight()
        .should(
            seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodigoRespuestaServicioError.class, CODIGO_RESPUESTA_SERVICIO));
    theActorInTheSpotlight()
        .should(
            seeThat(
                    CodigoEstadoCotizacion.obtenido(
                        SerenityRest.lastResponse().as(ResponseCotizacionSoat.class)),
                    equalTo(ESTADO_DATOS_ERRADOS_RUNT_Y_USUARIO.getCodigoEstado()))
                .orComplainWith(CodigoEstadoError.class, CODIGO_ESTADO_ERROR),
            seeThat(
                    ListaErroresVehiculo.obtenida(
                        SerenityRest.lastResponse().as(ResponseCotizacionSoat.class)),
                    hasItems(Cadenas.separarCadenas(mensajesError, EnumSeparadores.SEPARADOR_COMA)))
                .orComplainWith(MensajeInexistenteError.class, MENSAJE_INEXISTENTE_ERROR));
  }
}
