package com.voice.iot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProblemDto
 */

public class ProblemDto  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("type")
  private String type = "about:blank";

  @JsonProperty("title")
  private String title;

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("detail")
  private String detail;

  @JsonProperty("instance")
  private String instance;

  public ProblemDto type(String type) {
    this.type = type;
    return this;
  }

  /**
   * An absolute URI that identifies the problem type.  When dereferenced, it SHOULD provide human-readable documentation for the problem type (e.g., using HTML). 
   * @return type
  */
  @ApiModelProperty(example = "https://api.avaya.com/problem/constraint-violation", value = "An absolute URI that identifies the problem type.  When dereferenced, it SHOULD provide human-readable documentation for the problem type (e.g., using HTML). ")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProblemDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non-technical stakeholders and not localized); example: Service Unavailable 
   * @return title
  */
  @ApiModelProperty(value = "A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non-technical stakeholders and not localized); example: Service Unavailable ")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ProblemDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP status code generated by the origin server for this occurrence of the problem. 
   * minimum: 100
   * maximum: 600
   * @return status
  */
  @ApiModelProperty(example = "503", value = "The HTTP status code generated by the origin server for this occurrence of the problem. ")

@Min(100) @Max(600) 
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ProblemDto detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human readable explanation specific to this occurrence of the problem. 
   * @return detail
  */
  @ApiModelProperty(example = "Connection to database timed out", value = "A human readable explanation specific to this occurrence of the problem. ")


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public ProblemDto instance(String instance) {
    this.instance = instance;
    return this;
  }

  /**
   * An absolute URI that identifies the specific occurrence of the problem. It may or may not yield further information if dereferenced.
   * @return instance
  */
  @ApiModelProperty(value = "An absolute URI that identifies the specific occurrence of the problem. It may or may not yield further information if dereferenced.")


  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDto problem = (ProblemDto) o;
    return Objects.equals(this.type, problem.type) &&
        Objects.equals(this.title, problem.title) &&
        Objects.equals(this.status, problem.status) &&
        Objects.equals(this.detail, problem.detail) &&
        Objects.equals(this.instance, problem.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, detail, instance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDto {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
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
