package co.com.segurossura.certification.soat.interactions.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.integrations.InsertaRegistroBaseDatos;
import co.com.segurossura.certification.soat.models.basedatos.Parametros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class InsertarDatos implements Interaction {

  private final Parametros parametros;

  public InsertarDatos(Parametros parametros) {
    this.parametros = parametros;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    InsertaRegistroBaseDatos.insertarRegistroBD(parametros);
  }

  public static InsertarDatos conLosParametros(Parametros parametros) {
    return instrumented(InsertarDatos.class, parametros);
  }
}
