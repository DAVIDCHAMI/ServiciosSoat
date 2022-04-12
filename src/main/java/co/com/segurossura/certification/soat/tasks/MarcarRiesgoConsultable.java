package co.com.segurossura.certification.soat.tasks;

import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios.SERVICIOS_SOAP;
import static co.com.segurossura.certification.soat.utils.enums.EnumRecursosServicios.BASE_URL_SOAP;
import static co.com.segurossura.certification.soat.utils.enums.EnumRecursosServicios.RECURSO_RIESGOS_CONSULTABLES_SOAP;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.servicios.ConsumirServicio;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class MarcarRiesgoConsultable implements Task {

  Map<String, String> header1 = new HashMap<>();
  Map<String, String> header2 = new HashMap<>();
  Map<String, String> header3 = new HashMap<>();
  String codigoCausal;

  public MarcarRiesgoConsultable(String codigoCausal) {
    header1.put("Accept-Encoding", "gzip,deflate");
    header2.put("Content-Type", "text/xml;charset=UTF-8");
    header3.put("Connection", "Keep-Alive");
    this.codigoCausal = codigoCausal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Actor sam = Actor.named("Sam").whoCan(CallAnApi.at(BASE_URL_SOAP.getRecurso()));
    sam.attemptsTo(
        ConsumirServicio.soapConHeaders(
            RECURSO_RIESGOS_CONSULTABLES_SOAP.getRecurso(),
            SERVICIOS_SOAP,
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.consultables.riesgos.sura.com.co/\">"
                + "<soapenv:Header>\n"
                + "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n"
                + "\t<wsse:UsernameToken wsu:Id=\"UsernameToken-1ACCD309B6EA83BBF5159104028396798\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "\t<wsse:Username>coregw</wsse:Username>\n"
                + "\t<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">co8re951*G/650w</wsse:Password>\n"
                + "\t</wsse:UsernameToken>\n"
                + "      </wsse:Security>\n"
                + "</soapenv:Header>"
                + "   <soapenv:Body>\n"
                + "      <ser:ingresarRiesgo>\n"
                + "         <riesgo>\n"
                + "            <causal>"
                + codigoCausal
                + "</causal>\n"
                + "            <codigoAgente>4999</codigoAgente>\n"
                + "             <codigoDelegacion>10</codigoDelegacion>\n"
                + "            <DNIUsuario>C7418426</DNIUsuario>\n"
                + "            <documentoOrigen>Documento</documentoOrigen>\n"
                + "            <fuente>20</fuente>\n"
                + "            <inicioVigencia>2020-05-20</inicioVigencia>\n"
                + "            <pais>57</pais>\n"
                + "            <riesgo>C1037695448</riesgo>\n"
                + "             <tipoRiesgo>01</tipoRiesgo>\n"
                + "            <usuario>LUZEVAMO</usuario>\n"
                + "         </riesgo>\n"
                + "      </ser:ingresarRiesgo>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>",
            header1,
            header2,
            header3));
  }

  public static Performable conDatos(String codigoCausal) {
    return instrumented(MarcarRiesgoConsultable.class, codigoCausal);
  }
}
