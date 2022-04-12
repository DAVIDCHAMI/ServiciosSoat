#language:es

Característica: Expedir SOAT de vehiculo
  Yo como usuario
  Quiero expedir el SOAT de un vehículo
  Para validar que se expidió exitosamente

  @ExpedicionSoatExitosamente
  Escenario: Expedir el SOAT de un vehículo exitosamente
    Dado que una persona "riesgo estandar" tiene un "Auto familiar con menos de 1500 c.c y modelo 2015" registrado en el Runt
    Cuando el cliente expide el Soat
    Entonces debería ver que el Soat se expidió de manera exitosa con tarifa 368800.0