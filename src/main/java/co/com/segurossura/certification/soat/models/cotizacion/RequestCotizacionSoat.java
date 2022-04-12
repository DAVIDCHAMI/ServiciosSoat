package co.com.segurossura.certification.soat.models.cotizacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"canal", "placa"})
@Builder
public class RequestCotizacionSoat implements Serializable {

  @JsonProperty("canal")
  private final String canal;

  @JsonProperty("placa")
  private final String placa;

  @JsonProperty("datosErradosRunt")
  private final List<DatosErradosRunt> datosErradosRunt;

  private static final long serialVersionUID = -4991650367532370553L;
}
