package co.com.segurossura.certification.soat.runners.validacionprepoliza;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/validacionprepoliza/validar_soat_con_fecha_inicio_vigencia_mayor_6_meses.feature",
    glue = {"co.com.segurossura.certification.soat.stepdefinitions"})
public class ValidarSoatConFechaInicioVigenciaMayor6Meses {}
