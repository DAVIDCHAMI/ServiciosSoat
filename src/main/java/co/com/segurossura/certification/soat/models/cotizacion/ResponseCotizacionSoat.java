package co.com.segurossura.certification.soat.models.cotizacion;

import co.com.segurossura.certification.soat.models.comunes.Tarifa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"codigoEstado", "tarifa", "datosErradosVehiculo", "message"})
@Getter
public class ResponseCotizacionSoat implements Serializable {
  @JsonProperty("codigoEstado")
  private String codigoEstado;

  @JsonProperty("tarifa")
  private Tarifa tarifa;

  @JsonProperty("message")
  public String message;

  @JsonProperty("datosErradosVehiculo")
  private List<DatosErradosVehiculo> datosErradosVehiculo;

  private static final long serialVersionUID = 4545855629166319075L;
}
