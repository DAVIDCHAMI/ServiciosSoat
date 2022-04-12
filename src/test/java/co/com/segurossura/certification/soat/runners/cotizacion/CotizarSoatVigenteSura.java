package co.com.segurossura.certification.soat.runners.cotizacion;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/cotizacion/cotizar_soat_vigente_sura.feature",
    glue = {"co.com.segurossura.certification.soat.stepdefinitions"})
public class CotizarSoatVigenteSura {}
