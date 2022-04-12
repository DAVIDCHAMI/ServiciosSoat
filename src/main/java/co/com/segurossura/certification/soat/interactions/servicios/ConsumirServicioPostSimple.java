package co.com.segurossura.certification.soat.interactions.servicios;

import co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumirServicioPostSimple implements Interaction {

  private final String recurso;
  private final String usuario;
  private final String contrasena;
  private final Object request;

  public ConsumirServicioPostSimple(
      String recurso, EnumCredencialesServicios enumCredenciales, Object request) {
    this.recurso = recurso;
    usuario = enumCredenciales.getUsuario();
    contrasena = enumCredenciales.getContrasena();
    this.request = request;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(recurso)
            .with(
                requestSpecification ->
                    requestSpecification
                        .auth()
                        .preemptive()
                        .basic(usuario, contrasena)
                        .contentType(ContentType.JSON)
                        .body(request)));
  }
}
