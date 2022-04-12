package co.com.segurossura.certification.soat.utils;

import org.slf4j.LoggerFactory;

public final class Logger {

  private Logger() {}

  public static void error(String clase, String mensaje) {
    LoggerFactory.getLogger(clase).error(mensaje);
  }

  public static void info(String clase, String mensaje) {
    LoggerFactory.getLogger(clase).info(mensaje);
  }
}
