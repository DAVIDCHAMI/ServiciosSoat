package co.com.segurossura.certification.soat.interactions.servicios;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class Get extends RestInteraction {

  private final String resource;

  public Get(String resource) {
    this.resource = resource;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    rest().log().all().get(as(actor).resolve(resource)).then().log().all();
  }

  public static Get resource(String resource) {
    return new Get(resource);
  }
}
