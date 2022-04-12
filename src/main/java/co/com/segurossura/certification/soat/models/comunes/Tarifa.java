package co.com.segurossura.certification.soat.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"prima", "contribucion", "runt", "costoTotal", "codigoTarifa"})
@Getter
public class Tarifa implements Serializable {

  @JsonProperty("prima")
  private Float prima;

  @JsonProperty("contribucion")
  private Float contribucion;

  @JsonProperty("runt")
  private Float runt;

  @JsonProperty("costoTotal")
  private Float costoTotal;

  @JsonProperty("codigoTarifa")
  private Integer codigoTarifa;

  private static final long serialVersionUID = 1644897090862406096L;
}
