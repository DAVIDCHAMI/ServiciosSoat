package co.com.segurossura.certification.soat.models.comunes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "codigoEstado",
  "poliza",
  "cotizacion",
  "message",
  "datosErradosPoliza,",
  "detail",
  "idPago"
})
@Getter
public class ResponsePolizaSoat implements Serializable {
  @JsonProperty("codigoEstado")
  private String codigoEstado;

  @JsonProperty("poliza")
  private String poliza;

  @JsonProperty("cotizacion")
  private Tarifa cotizacion;

  @JsonProperty("message")
  public String message;

  @JsonProperty("datosErradosPoliza")
  private List<DatosErradosPoliza> datosErradosPoliza = null;

  @JsonProperty("detail")
  public String detail;

  @JsonProperty("idPago")
  private String idPago;

  private static final long serialVersionUID = 866218153276894858L;
}
