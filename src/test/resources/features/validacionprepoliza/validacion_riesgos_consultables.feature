#language: es
Característica: Validar que no permita gestionar un SOAT cuando el propietario sea riesgo moral
  Yo como usuario
  Quiero que al validar no permita gestionar el valor del SOAT a una persona que es un Riesgo Moral
  Para validar el control que levanta el servicio de Validación Prepoliza

  @RiesgoConsultable
  Escenario: Validar SOAT donde el Tomador es un Riesgo Moral
    Dado que el tomador es un "riesgo moral" con codigo "000018" quiere adquirir el "SOAT con Sura"
    Cuando el usuario valide el SOAT con Sura
    Entonces deberia ver un mensaje indicando que no se puede gestionar el SOAT debido a que es un riesgo alto






