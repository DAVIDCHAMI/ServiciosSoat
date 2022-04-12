#language: es
Característica: Cotizar SOAT con SOAT Vigente con SURA
  Yo como usuario
  Quiero cotizar un SOAT con SOAT Vigente con SURA
  Para validar un mensaje de error

  @CotizarSoatConSoatVigente
  Escenario: Cotizar SOAT teniendo un SOAT vigente con Sura
    Dado que una persona "riesgo estandar" tiene un "SOAT vigente con Sura"
    Cuando el usuario cotiza el valor del SOAT
    Entonces debería ver un mensaje indicando que se tiene un SOAT vigente con Sura
