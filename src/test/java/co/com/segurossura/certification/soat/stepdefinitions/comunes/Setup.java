package co.com.segurossura.certification.soat.stepdefinitions.comunes;

import static co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos.configurarBaseDeDatosConLosParametros;
import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesBaseDatos.BASE_DATOS_SOAT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.models.comunes.ResponsePolizaSoat;
import co.com.segurossura.certification.soat.tasks.validacionprepoliza.AnularPrepoliza;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class Setup {

  EnvironmentVariables environmentVariable;
  String urlBase;
  String prePoliza = null;

  @Before(order = 0)
  public void configurarUrlBase() {
    final String RUTA_URL = "restapi.baseurl";
    environmentVariable = Injectors.getInjector().getInstance(EnvironmentVariables.class);
    urlBase = EnvironmentSpecificConfiguration.from(environmentVariable).getProperty(RUTA_URL);
  }

  @Before(order = 1)
  public void configurarActor() {
    OnStage.setTheStage(new OnlineCast());
    theActorCalled("René").whoCan(CallAnApi.at(urlBase));
  }

  @Before
  public void inicializacionBaseDatos() {
    ConectarseALaBaseDeDatos.as(
            theActorInTheSpotlight()
                .whoCan(
                    configurarBaseDeDatosConLosParametros(
                        BASE_DATOS_SOAT.getUrlBaseDatos(),
                        BASE_DATOS_SOAT.getUsuario(),
                        BASE_DATOS_SOAT.getContrasena())))
        .realizarConexionBaseDatos();
  }

  @After("@ValidarSOATVigenteConMenosDe6MesesInicioDeVigenciaMayorALaFechaFin")
  public void anularPrepoliza() {
    prePoliza = String.valueOf(environmentVariable.getProperty("anularprepoliza.prePoliza"));
    theActorInTheSpotlight().whoCan(CallAnApi.at(prePoliza));
    theActorInTheSpotlight()
        .attemptsTo(
            AnularPrepoliza.conIdDePago(SerenityRest.lastResponse().as(ResponsePolizaSoat.class)));
  }
}
