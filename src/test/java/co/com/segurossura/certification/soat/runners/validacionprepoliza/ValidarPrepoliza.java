package co.com.segurossura.certification.soat.runners.validacionprepoliza;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
    features = "src/test/resources/features/validacionprepoliza/validar_prepoliza.feature",
    glue = "co.com.segurossura.certification.soat.stepdefinitions")
@RunWith(CucumberWithSerenity.class)
public class ValidarPrepoliza {}
