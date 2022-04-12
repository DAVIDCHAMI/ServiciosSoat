package co.com.segurossura.certification.soat.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "idTipoServicio",
  "idClaseVehiculo",
  "idMarca",
  "idLinea",
  "modelo",
  "noMotor",
  "noChasis",
  "noVin",
  "cilindraje",
  "noPlaca",
  "capacidadPasajerosSentados",
  "datosTecnicos"
})
@Builder
@Getter
public class VehiculoRuntBD implements Serializable {

  @JsonProperty("idTipoServicio")
  private final String idTipoServicio;

  @JsonProperty("idClaseVehiculo")
  private final String idClaseVehiculo;

  @JsonProperty("idMarca")
  private final String idMarca;

  @JsonProperty("idLinea")
  private final String idLinea;

  @JsonProperty("modelo")
  private final String modelo;

  @JsonProperty("noMotor")
  private final String noMotor;

  @JsonProperty("noChasis")
  private final String noChasis;

  @JsonProperty("noVin")
  private final String noVin;

  @JsonProperty("cilindraje")
  private final String cilindraje;

  @JsonProperty("noPlaca")
  private final String noPlaca;

  @JsonProperty("capacidadPasajerosSentados")
  private final String capacidadPasajerosSentados;

  @JsonProperty("datosTecnicos")
  private final DatosTecnicos datosTecnicos;

  private static final long serialVersionUID = -3497274066804653542L;
}
