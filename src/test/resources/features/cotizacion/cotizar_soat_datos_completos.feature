#language: es

@Cotizacion
Característica: Cotizar SOAT para vehículos con datos completos en el RUNT
  Yo como usuario
  Quiero cotizar el SOAT de mi vehículo cuando viene con datos completos desde el RUNT
  Para conocer el costo total del SOAT.

  Esquema del escenario: Cotizar exitosamente el valor del SOAT con tarifas que dependen de clase de vehículo y cilindraje
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo | <Clase de vehículo> |
      | Cilindraje        | <Cilindraje>        |
    Cuando cotice el valor del SOAT
    Entonces debería ver que el costo total del SOAT es igual a <Costo total>
    Ejemplos:
      | Clase de vehículo                          | Cilindraje                           | Costo total |
      | Motos                                      | Ciclomotor                           | 200200      |
      | Motos                                      | Menos de 100 c.c.                    | 414800      |
      | Motos                                      | Entre 100 - 200 c.c                  | 556500      |
      | Motos                                      | Mas de 200 c.c                       | 627600      |
      | Motos                                      | Motocarros Tricimotos y Cuadriciclos | 627600      |
      | Vehículos oficiales especiales ambulancias | Menos de 1500 c.c                    | 824000      |
      | Vehículos oficiales especiales ambulancias | Entre 1500  -  2500 c.c              | 1038600     |
      | Vehículos oficiales especiales ambulancias | Más de 2500 c.c                      | 1245200     |

  Esquema del escenario: Cotizar exitosamente el valor del SOAT con tarifas que dependen de clase de vehículo, cilindraje y modelo
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo | <Clase de vehículo> |
      | Cilindraje        | <Cilindraje>        |
      | Modelo            | <Modelo>            |
    Cuando cotice el valor del SOAT
    Entonces debería ver que el costo total del SOAT es igual a <Costo total>
    Ejemplos:
      | Clase de vehículo                              | Cilindraje             | Modelo | Costo total |
      | Camperos y camionetas                          | Menos de 1500 c.c      | 2015   | 653500      |
      | Camperos y camionetas                          | Menos de 1500 c.c      | 2010   | 785600      |
      | Camperos y camionetas                          | Entre 1500 -  2500 c.c | 2015   | 780400      |
      | Camperos y camionetas                          | Entre 1500 -  2500 c.c | 2009   | 924300      |
      | Camperos y camionetas                          | Más de 2500 c.c        | 2015   | 915200      |
      | Camperos y camionetas                          | Más de 2500 c.c        | 2008   | 1050200     |
      | Autos familiares                               | Menos de 1500 c.c      | 2015   | 368800      |
      | Autos familiares                               | Menos de 1500 c.c      | 2010   | 488900      |
      | Autos familiares                               | Entre 1500 -  2500 c.c | 2015   | 448900      |
      | Autos familiares                               | Entre 1500 -  2500 c.c | 2009   | 558500      |
      | Autos familiares                               | Más de 2500 c.c        | 2015   | 524300      |
      | Autos familiares                               | Más de 2500 c.c        | 2008   | 621900      |
      | Vehículos con capacidad para 6 ó mas pasajeros | Menos de 2500 c.c      | 2015   | 657400      |
      | Vehículos con capacidad para 6 ó mas pasajeros | Menos de 2500 c.c      | 2010   | 838900      |
      | Vehículos con capacidad para 6 ó mas pasajeros | 2500 o más c.c         | 2015   | 879800      |
      | Vehículos con capacidad para 6 ó mas pasajeros | 2500 o más c.c         | 2009   | 1056400     |

  Esquema del escenario: Cotizar exitosamente el valor del SOAT con tarifas que dependen de clase de vehículo y toneladas
    Dado que René tiene un vehículo con las siguientes características
      | Clase de vehículo | <Clase de vehículo> |
      | Toneladas         | <Toneladas>         |
    Cuando cotice el valor del SOAT
    Entonces debería ver que el costo total del SOAT es igual a <Costo total>
    Ejemplos:
      | Clase de vehículo         | Toneladas          | Costo total |
      | Vehículo de carga o mixto | Menos de 5 Tons.   | 732400      |
      | Vehículo de carga o mixto | Entre 5 y 15 Tons. | 1057500     |
      | Vehículo de carga o mixto | Más de 15 Tons.    | 1337000     |