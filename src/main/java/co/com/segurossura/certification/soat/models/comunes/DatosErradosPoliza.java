package co.com.segurossura.certification.soat.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"dato", "descripcionError"})
@Getter
public class DatosErradosPoliza implements Serializable {

  @JsonProperty("dato")
  private String dato;

  @JsonProperty("descripcionError")
  private List<String> descripcionError = null;

  private static final long serialVersionUID = 181830800476024765L;
}
