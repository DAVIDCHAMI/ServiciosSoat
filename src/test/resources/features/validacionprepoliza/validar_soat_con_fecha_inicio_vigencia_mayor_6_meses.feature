#language: es
Característica: Validar SOAT con una fecha de inicio de vigencia mayor a 6 meses
  Yo como usuario
  Quiero validar un SOAT vigente con mas de 6 meses para vencerse
  Para validar el control que levanta el servicio de Validación Prepoliza

  @ValidacionPrepolizaMayor6Meses
  Escenario: Validar SOAT vigente con fecha de inicio de vigencia mayor a 6 meses
    Dado que una persona "riesgo estandar" tiene un "Soat vigente con más de 6 meses para vencerse" con sura
    Cuando el usuario intente validar el soat vigente
    Entonces debería ver un mensaje indicando que tiene un Soat vigente con una fecha vencimiento mayor a seis meses



