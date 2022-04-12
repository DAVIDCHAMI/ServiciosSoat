package co.com.segurossura.certification.soat.interactions.servicios;

import co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios;
import io.restassured.http.ContentType;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumirServicioPostConHeaders implements Interaction {

  private final String recurso;
  private final String usuario;
  private final String contrasena;
  private final Object request;
  private final Map<String, ?> headers;

  public ConsumirServicioPostConHeaders(
      String recurso,
      EnumCredencialesServicios enumCredenciales,
      Object request,
      Map<String, ?> headers) {
    this.recurso = recurso;
    usuario = enumCredenciales.getUsuario();
    contrasena = enumCredenciales.getContrasena();
    this.request = request;
    this.headers = headers;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(recurso)
            .with(
                requestSpecification ->
                    requestSpecification
                        .headers(headers)
                        .auth()
                        .preemptive()
                        .basic(usuario, contrasena)
                        .contentType(ContentType.JSON)
                        .body(request)));
  }
}
