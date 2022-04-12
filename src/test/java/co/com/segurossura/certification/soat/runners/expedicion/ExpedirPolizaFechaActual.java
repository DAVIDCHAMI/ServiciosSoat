package co.com.segurossura.certification.soat.runners.expedicion;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
    features = "src/test/resources/features/expedicion/expedir_poliza_fecha_actual.feature",
    glue = "co.com.segurossura.certification.soat.stepdefinitions")
@RunWith(CucumberWithSerenity.class)
public class ExpedirPolizaFechaActual {}
