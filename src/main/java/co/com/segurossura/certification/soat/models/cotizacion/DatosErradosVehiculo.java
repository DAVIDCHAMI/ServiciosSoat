package co.com.segurossura.certification.soat.models.cotizacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"dato", "descripcionError"})
@Getter
public class DatosErradosVehiculo implements Serializable {

  @JsonProperty("dato")
  private String dato;

  @JsonProperty("descripcionError")
  private List<String> descripcionError;

  private static final long serialVersionUID = -6992805542066395855L;
}
