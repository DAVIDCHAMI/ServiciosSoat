package co.com.segurossura.certification.soat.models.cotizacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"dato", "valor"})
@Builder
public class DatosErradosRunt implements Serializable {

  @JsonProperty("dato")
  private final String dato;

  @JsonProperty("valor")
  private final String valor;

  private static final long serialVersionUID = -6992805542066395855L;
}
