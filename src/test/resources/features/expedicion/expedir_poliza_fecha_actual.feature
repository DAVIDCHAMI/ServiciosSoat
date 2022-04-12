#language:es

Característica: Expedir SOAT de vehiculo en la fecha actual
  Yo como usuario
  Quiero expedir el SOAT de un vehículo con fecha del dia actual
  Para validar que se levante un control y no expida


  @ExpedicionSoatConFechaActual
  Escenario: Expedir el SOAT de un vehículo con fecha del dia actual

    Dado que una persona "riesgo estandar" tiene un "Auto familiar con mas de 2500 c.c y modelo 2011" registrado en el Runt
    Cuando el cliente expide el Soat con inicio de vigencia "actual"
    Entonces debería ver un mensaje indicando que la fecha debe ser mayor al dia de hoy

