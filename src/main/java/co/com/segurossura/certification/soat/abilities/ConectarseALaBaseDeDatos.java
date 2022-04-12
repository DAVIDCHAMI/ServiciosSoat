package co.com.segurossura.certification.soat.abilities;

import static java.sql.DriverManager.getConnection;

import co.com.segurossura.certification.soat.exceptions.ActorNoPuedeConectarseBaseDatosException;
import co.com.segurossura.certification.soat.utils.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RefersToActor;

public class ConectarseALaBaseDeDatos implements Ability, RefersToActor {

  private final String urlBaseDatos;
  private final String usuario;
  private final String contrasena;
  private static Connection conexion;

  public ConectarseALaBaseDeDatos(String urlBaseDatos, String usuario, String contrasena) {
    this.urlBaseDatos = urlBaseDatos;
    this.usuario = usuario;
    this.contrasena = contrasena;
  }

  public static ConectarseALaBaseDeDatos configurarBaseDeDatosConLosParametros(
      String urlBaseDatos, String usuario, String contrasena) {
    return new ConectarseALaBaseDeDatos(urlBaseDatos, usuario, contrasena);
  }

  public static ConectarseALaBaseDeDatos as(Actor actor) {
    if (actor.abilityTo(ConectarseALaBaseDeDatos.class) == null) {
      throw new ActorNoPuedeConectarseBaseDatosException();
    }
    return actor.abilityTo(ConectarseALaBaseDeDatos.class).asActor(actor);
  }

  public void realizarConexionBaseDatos() {
    try {
      setConexion(getConnection(urlBaseDatos, usuario, contrasena));
    } catch (SQLException ex) {
      Logger.error(
          "ConectarseALaBaseDeDatos",
          "No se pudo realizar la conexión a la base de datos, con la excepción " + ex);
    }
  }

  public static void cerrarConexion() {
    try {
      ConectarseALaBaseDeDatos.getConexion().close();
    } catch (SQLException ex) {
      Logger.error(
          "ConectarseALaBaseDeDatos",
          "No se pudo cerrar la conexión a la base de datos, con la excepción " + ex);
    }
  }

  public static Connection getConexion() {
    return conexion;
  }

  public static void setConexion(Connection setParametrosConexion) {
    conexion = setParametrosConexion;
  }

  @Override
  public <T extends Ability> T asActor(Actor actor) {
    return (T) this;
  }

  @Override
  public String toString() {
    return "Consulta la base de datos";
  }
}
