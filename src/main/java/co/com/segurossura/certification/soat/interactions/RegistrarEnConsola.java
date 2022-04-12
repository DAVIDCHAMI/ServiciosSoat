package co.com.segurossura.certification.soat.interactions;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import org.slf4j.LoggerFactory;

public class RegistrarEnConsola implements Interaction, CanBeSilent {

  private final String clase;
  private final String mensaje;

  public RegistrarEnConsola(String clase, String mensaje) {
    this.clase = clase;
    this.mensaje = mensaje;
  }

  public static Performable elMensaje(String clase, String mensaje) {
    return Tasks.instrumented(RegistrarEnConsola.class, clase, mensaje);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    LoggerFactory.getLogger(clase).info(mensaje);
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
