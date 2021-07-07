package com.voice.iot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.voice.iot.model.DeviceDto;
import com.voice.iot.model.PaginationDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DevicesDto
 */

public class DevicesDto  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pagination")
  private PaginationDto pagination = null;

  @JsonProperty("groups")
  @Valid
  private List<DeviceDto> groups = null;

  public DevicesDto pagination(PaginationDto pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  */
  @ApiModelProperty(value = "")

  @Valid

  public PaginationDto getPagination() {
    return pagination;
  }

  public void setPagination(PaginationDto pagination) {
    this.pagination = pagination;
  }

  public DevicesDto groups(List<DeviceDto> groups) {
    this.groups = groups;
    return this;
  }

  public DevicesDto addGroupsItem(DeviceDto groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<DeviceDto> getGroups() {
    return groups;
  }

  public void setGroups(List<DeviceDto> groups) {
    this.groups = groups;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DevicesDto devices = (DevicesDto) o;
    return Objects.equals(this.pagination, devices.pagination) &&
        Objects.equals(this.groups, devices.groups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, groups);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DevicesDto {\n");
    
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

