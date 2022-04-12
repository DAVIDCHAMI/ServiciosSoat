package co.com.segurossura.certification.soat.stepdefinitions.comunes;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.tasks.basedatos.ConsultarRegistro;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistro;
import io.cucumber.java.After;

public final class Hooks {

  @After(order = 1)
  public void cerrarConexion() {
    ConectarseALaBaseDeDatos.cerrarConexion();
  }

  @After(
      "@ExpedicionSoatExitosamente or @ValidarSOATVigenteConMenosDe6MesesParaVencerse or @CotizarSoatConSoatVigente or @ValidacionPrepolizaMayor6Meses or @ValidarSOATVigenteConMenosDe6MesesInicioDeVigenciaMayorALaFechaFin")
  public static void eliminarRegistrosPolizaExpedida() {
    ConsultarRegistro.numeroPoliza();
    EliminarRegistro.vehiculoRunt();
    EliminarRegistro.polizaSoat();
    EliminarRegistro.polizaSiis();
  }

  @After("@Cotizacion or @ExpedicionSoatConFechaActual or @RiesgoConsultable")
  public static void eliminarRegistroRunt() {
    EliminarRegistro.vehiculoRunt();
  }
}
