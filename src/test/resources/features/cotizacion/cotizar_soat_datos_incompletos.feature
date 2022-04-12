#language: es

@Cotizacion
Característica: Cotizar SOAT para vehículos con datos incompletos en el RUNT
  Yo como usuario
  Quiero cotizar el SOAT de mi vehículo cuando viene con datos incompletos desde el RUNT
  Para conocer el costo total del SOAT.

  Esquema del escenario: Cotizar el valor del SOAT con tarifas dependientes de clase de vehículo, cilindraje, modelo y el tipo de servicio en la solicitud
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo | <Clase de vehículo> |
      | Cilindraje        | <Cilindraje>        |
      | Modelo            | <Modelo>            |
    Cuando cotice el valor del SOAT agregando los datos
      | idTipoServicio | 1 |
    Entonces debería ver que el costo total del SOAT es igual a <Costo total>
    Ejemplos:
      | Clase de vehículo                           | Cilindraje              | Modelo | Costo total |
      | Autos de negocio taxis y microbuses urbanos | Menos de 1500 c.c.      | 2020   | 456600      |
      | Autos de negocio taxis y microbuses urbanos | Menos de 1500 c.c.      | 2010   | 570500      |
      | Autos de negocio taxis y microbuses urbanos | Entre 1500 -  2500 c.c. | 2019   | 567600      |
      | Autos de negocio taxis y microbuses urbanos | Entre 1500 -  2500 c.c. | 2009   | 701500      |
      | Autos de negocio taxis y microbuses urbanos | Más de 2500 c.c.        | 2018   | 732400      |
      | Autos de negocio taxis y microbuses urbanos | Más de 2500 c.c.        | 2008   | 859100      |

  Escenario: Cotizar el valor del SOAT con tarifa dependiente de la clase de vehículo y el tipo de servicio en la solicitud
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo | Vehículos de servicio público urbano buses y busetas |
    Cuando cotice el valor del SOAT agregando los datos
      | idTipoServicio | 1 |
    Entonces debería ver que el costo total del SOAT es igual a 1093100

  Esquema del escenario: Cotizar el valor del SOAT con tarifas dependientes de clase de vehículo, cantidad de pasajeros y el tipo de servicio en la solicitud
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo     | <Clase de vehículo>     |
      | Cantidad de pasajeros | <Cantidad de pasajeros> |
    Cuando cotice el valor del SOAT agregando los datos
      | idTipoServicio | 2 |
    Entonces debería ver que el costo total del SOAT es igual a <Costo total>
    Ejemplos:
      | Clase de vehículo                   | Cantidad de pasajeros | Costo total |
      | Vehículo de servicio intermunicipal | Menos de 10 pasajeros | 1081100     |
      | Vehículo de servicio intermunicipal | 10  ó  Más pasajeros  | 1568500     |

  Esquema del escenario: Cotizar el valor del SOAT enviando campos pendientes obligatorios que vienen vacíos desde el RUNT
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo       | <Clase de vehículo>       |
      | Cilindraje del vehículo | <Cilindraje del vehículo> |
      | Modelo del vehículo     | <Modelo del vehículo>     |
    Cuando cotice el valor del SOAT agregando los datos
      | idTipoServicio | <idTipoServicio> |
      | cilindraje     | <cilindraje>     |
      | modelo         | <modelo>         |
    Entonces debería ver que el costo total del SOAT es igual a <Costo total>
    Ejemplos:
      | Clase de vehículo                              | Cilindraje del vehículo | Modelo del vehículo | idTipoServicio | cilindraje | modelo | Costo total |
      | Camperos y camionetas                          | Sin cilindraje          | 2020                | N/A            | 1300       | N/A    | 653500      |
      | Autos familiares                               | Entre 1500 -  2500 c.c  | Sin modelo          | N/A            | N/A        | 2010   | 558500      |
      | Vehículos con capacidad para 6 ó mas pasajeros | Sin cilindraje          | Sin modelo          | N/A            | 2500       | 2019   | 879800      |
      | Autos de negocio taxis y microbuses urbanos    | Sin cilindraje          | Sin modelo          | 1              | 1110       | 2005   | 570500      |

  Esquema del escenario: Cotizar el valor del SOAT enviando erróneamente campos pendientes obligatorios que vienen vacíos desde el RUNT
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo       | <Clase de vehículo>       |
      | Cilindraje del vehículo | <Cilindraje del vehículo> |
      | Modelo del vehículo     | <Modelo del vehículo>     |
    Cuando cotice el valor del SOAT agregando los datos
      | idTipoServicio | <idTipoServicio> |
      | cilindraje     | <cilindraje>     |
      | modelo         | <modelo>         |
    Entonces debería ver los mensajes de error '<Mensajes de error>'
    Ejemplos:
      | Clase de vehículo                              | Cilindraje del vehículo | Modelo del vehículo | idTipoServicio | cilindraje | modelo | Mensajes de error                                                                                          |
      | Camperos y camionetas                          | Sin cilindraje          | 2020                | N/A            | a          | N/A    | El cilindraje debe ser numérico                                                                            |
      | Autos familiares                               | Entre 1500 -  2500 c.c  | Sin modelo          | N/A            | N/A        | a      | El modelo debe ser numérico                                                                                |
      | Vehículos con capacidad para 6 ó mas pasajeros | Sin cilindraje          | Sin modelo          | N/A            | a          | a      | El cilindraje debe ser numérico, El modelo debe ser numérico                                               |
      | Autos de negocio taxis y microbuses urbanos    | Sin cilindraje          | Sin modelo          | a              | a          | a      | El código de tipo servicio debe ser numérico, El cilindraje debe ser numérico, El modelo debe ser numérico |