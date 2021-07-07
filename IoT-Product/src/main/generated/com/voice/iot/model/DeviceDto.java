package com.voice.iot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.voice.iot.model.SimCardDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IOT tracking device 
 */
@ApiModel(description = "IOT tracking device ")

public class DeviceDto  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("status")
  private String status;

  @JsonProperty("temperature")
  private String temperature;

  @JsonProperty("simId")
  private SimCardDto simId;

  public DeviceDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DeviceDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of Device.
   * @return name
  */
  @ApiModelProperty(example = "Samsara", value = "The name of Device.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeviceDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * device description
   * @return description
  */
  @ApiModelProperty(example = "description", value = "device description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DeviceDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * device status
   * @return status
  */
  @ApiModelProperty(example = "READY", value = "device status")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DeviceDto temperature(String temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * device temperature
   * @return temperature
  */
  @ApiModelProperty(example = "75'C", value = "device temperature")


  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public DeviceDto simId(SimCardDto simId) {
    this.simId = simId;
    return this;
  }

  /**
   * Get simId
   * @return simId
  */
  @ApiModelProperty(value = "")

  @Valid

  public SimCardDto getSimId() {
    return simId;
  }

  public void setSimId(SimCardDto simId) {
    this.simId = simId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceDto device = (DeviceDto) o;
    return Objects.equals(this.id, device.id) &&
        Objects.equals(this.name, device.name) &&
        Objects.equals(this.description, device.description) &&
        Objects.equals(this.status, device.status) &&
        Objects.equals(this.temperature, device.temperature) &&
        Objects.equals(this.simId, device.simId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, status, temperature, simId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeviceDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    simId: ").append(toIndentedString(simId)).append("\n");
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

