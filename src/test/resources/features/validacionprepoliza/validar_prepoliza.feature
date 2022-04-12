#language:es

Característica: Validar desde el servicio PrePoliza la vigencia del SOAT
  Yo como usuario
  Quiero validar el servicio de Prepoliza para el SOAT
  Para verificar la tarifa y los mensajes de alerta.

  @ValidarSOATVigenteConMenosDe6MesesParaVencerse
  Escenario: validar un SOAT vigente con menos de 6 meses para vencerse
    Dado que una persona "riesgo estandar" tiene un "Auto familiar con menos de 1500 c.c y modelo 2018" registrado en el Runt
    Y tiene un soat con fecha de inicio de vigencia "retroactiva 7 meses"
    Cuando el cliente valide el soat con fecha de inicio de vigencia "anticipada 1 mes"
    Entonces debería ver un mensaje de error indicando que ya tiene un Soat vigente

  @ValidarSOATVigenteConMenosDe6MesesInicioDeVigenciaMayorALaFechaFin
  Escenario: validar un SOAT vigente con menos de 6 meses para vencerse e inicio de vigencia mayor a la fecha fin de la vigencia actual
    Dado que una persona "riesgo estandar" tiene un "Auto familiar con menos de 1500 c.c y modelo 2020" registrado en el Runt
    Y tiene un soat con fecha de inicio de vigencia "retroactiva 10 meses"
    Cuando el cliente valide el soat con fecha de inicio de vigencia "anticipada 3 mes"
    Entonces debería ver que la tarifa del SOAT es 368800.0