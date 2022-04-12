package co.com.segurossura.certification.soat.interactions.servicios;

import co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios;
import io.restassured.http.ContentType;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumirServicioSoapConHeaders implements Interaction {

  private final String recurso;
  private final String usuario;
  private final String contrasena;
  private final Object request;
  private final Map<String, ?> headers1;
  private final Map<String, ?> headers2;
  private final Map<String, ?> headers3;

  public ConsumirServicioSoapConHeaders(
      String recurso,
      EnumCredencialesServicios enumCredencialesServicios,
      Object request,
      Map<String, ?> headers1,
      Map<String, ?> headers2,
      Map<String, ?> headers3) {
    this.recurso = recurso;
    usuario = enumCredencialesServicios.getUsuario();
    contrasena = enumCredencialesServicios.getContrasena();
    this.request = request;
    this.headers1 = headers1;
    this.headers2 = headers2;
    this.headers3 = headers3;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(recurso)
            .with(
                requestSpecification ->
                    requestSpecification
                        .headers(headers1)
                        .headers(headers2)
                        .headers(headers3)
                        .auth()
                        .preemptive()
                        .basic(usuario, contrasena)
                        .contentType(ContentType.XML)
                        .body(request)));
  }
}
