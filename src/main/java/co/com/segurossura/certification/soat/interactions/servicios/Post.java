package co.com.segurossura.certification.soat.interactions.servicios;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class Post extends RestInteraction {

  private final String resource;

  public Post(String resource) {
    this.resource = resource;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    rest().log().all().post(as(actor).resolve(resource)).then().log().all();
  }

  public static Post to(String resource) {
    return new Post(resource);
  }
}
