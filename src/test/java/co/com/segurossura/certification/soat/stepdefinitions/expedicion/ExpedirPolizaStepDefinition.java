package co.com.segurossura.certification.soat.stepdefinitions.expedicion;

import static co.com.segurossura.certification.soat.exceptions.CodigoEstadoError.CODIGO_ESTADO_ERROR;
import static co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError.CODIGO_RESPUESTA_SERVICIO;
import static co.com.segurossura.certification.soat.exceptions.NumeroPolizaNoEncontrado.NUMERO_POLIZA_ERRADO;
import static co.com.segurossura.certification.soat.exceptions.ValorTarifaError.VALOR_TARIFA_ERRADO;
import static co.com.segurossura.certification.soat.utils.enums.EnumCodigoEstado.ESTADO_OK;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RESULTADO_CONSULTA_OBTENIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.CodigoEstadoError;
import co.com.segurossura.certification.soat.exceptions.CodigoRespuestaServicioError;
import co.com.segurossura.certification.soat.exceptions.NumeroPolizaNoEncontrado;
import co.com.segurossura.certification.soat.exceptions.ValorTarifaError;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.question.comunes.CodigoEstado;
import co.com.segurossura.certification.soat.question.comunes.CodigoRespuestaServicio;
import co.com.segurossura.certification.soat.question.comunes.NumeroPoliza;
import co.com.segurossura.certification.soat.question.comunes.ValorTarifaExpedicion;
import co.com.segurossura.certification.soat.tasks.basedatos.ConsultarRegistro;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.RegistrarVehiculoBaseDatos;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarDatosRequestPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.expedicion.ExpedirPoliza;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

public class ExpedirPolizaStepDefinition {

  @Dado("que una persona {string} tiene un {string} registrado en el Runt")
  public void registrarVehiculoRunt(String tipoRiesgo, String claseVehiculo) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    theActorInTheSpotlight().attemptsTo(RegistrarVehiculoBaseDatos.enElRuntConLosDatos());
    theActorInTheSpotlight().attemptsTo(AgregarDatosRequestPoliza.conTipoRiesgo(tipoRiesgo));
  }

  @Cuando("el cliente expide el Soat")
  public void expedirSoatExitosamente() {
    theActorInTheSpotlight().attemptsTo(ExpedirPoliza.paraElVehiculo());
    ConsultarRegistro.numeroPoliza();
  }

  @Entonces("debería ver que el Soat se expidió de manera exitosa con tarifa {float}")
  public void verificarNumeroPoliza(Float tarifaSoat) {
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
                .orComplainWith(ValorTarifaError.class, VALOR_TARIFA_ERRADO),
            seeThat(
                    NumeroPoliza.expedido(SerenityRest.lastResponse().as(ResponsePolizaSoat.class)),
                    equalTo(
                        theActorInTheSpotlight()
                            .recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion())))
                .orComplainWith(NumeroPolizaNoEncontrado.class, NUMERO_POLIZA_ERRADO));
  }
}
