package com.voice.iot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SIM (Subscriber Identification Module) card 
 */
@ApiModel(description = "SIM (Subscriber Identification Module) card ")

public class SimCardDto  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("simId")
  private UUID simId;

  @JsonProperty("operatorCode")
  private String operatorCode;

  @JsonProperty("country")
  private String country;

  /**
   * device status
   */
  public enum StatusEnum {
    ACTIVE("Active"),
    
    WAITING_FOR_ACTIVATION("Waiting for activation"),
    
    BLOCKED("Blocked"),
    
    DEACTIVATED("Deactivated");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  public SimCardDto simId(UUID simId) {
    this.simId = simId;
    return this;
  }

  /**
   * uniquely identify the SIM cardid.
   * @return simId
  */
  @ApiModelProperty(value = "uniquely identify the SIM cardid.")

  @Valid

  public UUID getSimId() {
    return simId;
  }

  public void setSimId(UUID simId) {
    this.simId = simId;
  }

  public SimCardDto operatorCode(String operatorCode) {
    this.operatorCode = operatorCode;
    return this;
  }

  /**
   * uniquely identify a mobile operator.
   * @return operatorCode
  */
  @ApiModelProperty(example = "Operator code", value = "uniquely identify a mobile operator.")


  public String getOperatorCode() {
    return operatorCode;
  }

  public void setOperatorCode(String operatorCode) {
    this.operatorCode = operatorCode;
  }

  public SimCardDto country(String country) {
    this.country = country;
    return this;
  }

  /**
   * country name.
   * @return country
  */
  @ApiModelProperty(example = "Italy", value = "country name.")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public SimCardDto status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * device status
   * @return status
  */
  @ApiModelProperty(value = "device status")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimCardDto simCard = (SimCardDto) o;
    return Objects.equals(this.simId, simCard.simId) &&
        Objects.equals(this.operatorCode, simCard.operatorCode) &&
        Objects.equals(this.country, simCard.country) &&
        Objects.equals(this.status, simCard.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(simId, operatorCode, country, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimCardDto {\n");
    
    sb.append("    simId: ").append(toIndentedString(simId)).append("\n");
    sb.append("    operatorCode: ").append(toIndentedString(operatorCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

