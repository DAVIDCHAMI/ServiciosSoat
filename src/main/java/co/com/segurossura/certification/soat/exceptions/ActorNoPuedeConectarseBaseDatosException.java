package co.com.segurossura.certification.soat.exceptions;

public class ActorNoPuedeConectarseBaseDatosException extends RuntimeException {
  public ActorNoPuedeConectarseBaseDatosException() {
    super("El actor no tiene la habilidad para conectarse a la base de datos");
  }
}
