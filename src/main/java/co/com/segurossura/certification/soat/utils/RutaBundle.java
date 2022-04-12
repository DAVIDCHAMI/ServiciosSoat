package co.com.segurossura.certification.soat.utils;

import java.util.ResourceBundle;

public abstract class RutaBundle {

  public static final ResourceBundle CONSULTAR_BASE_DATOS =
      ResourceBundle.getBundle("queries/consultar/consultar_registro");
  public static final ResourceBundle ELIMINAR_BASE_DATOS =
      ResourceBundle.getBundle("queries/eliminar/eliminar_registro");
  public static final ResourceBundle INSERTAR_BASE_DATOS =
      ResourceBundle.getBundle("queries/insertar/insertar_registro");
  public static final ResourceBundle ACTUALIZAR_BASE_DATOS =
      ResourceBundle.getBundle("queries/actualizar/actualizar_registro");

  private RutaBundle() {}
}
