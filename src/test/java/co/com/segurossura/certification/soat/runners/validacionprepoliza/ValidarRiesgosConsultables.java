package co.com.segurossura.certification.soat.runners.validacionprepoliza;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/validacionprepoliza/validacion_riesgos_consultables.feature",
    glue = "co.com.segurossura.certification.soat.stepdefinitions")
public class ValidarRiesgosConsultables {}
