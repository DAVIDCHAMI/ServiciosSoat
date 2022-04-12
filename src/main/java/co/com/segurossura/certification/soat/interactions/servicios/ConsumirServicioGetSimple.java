package co.com.segurossura.certification.soat.interactions.servicios;

import co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumirServicioGetSimple implements Interaction {

  private final String recurso;
  private final String usuario;
  private final String contrasena;

  public ConsumirServicioGetSimple(String recurso, EnumCredencialesServicios enumCredenciales) {
    this.recurso = recurso;
    usuario = enumCredenciales.getUsuario();
    contrasena = enumCredenciales.getContrasena();
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource(recurso)
            .with(
                requestSpecification ->
                    requestSpecification.auth().preemptive().basic(usuario, contrasena)));
  }
}
