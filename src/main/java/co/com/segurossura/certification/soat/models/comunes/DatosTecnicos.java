package co.com.segurossura.certification.soat.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"capacidadCarga", "pesoBrutoVehicular", "idTipoCombustible"})
@Builder
@Getter
public class DatosTecnicos implements Serializable {

  @JsonProperty("capacidadCarga")
  private final String capacidadCarga;

  @JsonProperty("pesoBrutoVehicular")
  private final String pesoBrutoVehicular;

  @JsonProperty("idTipoCombustible")
  private final String idTipoCombustible;

  private static final long serialVersionUID = 5116565515447908341L;
}
