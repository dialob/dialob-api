package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableValue implements Serializable {
  private String id;

  private Object value;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public VariableValue withId(String id) {
    this.id = id;
    return this;
  }

  public VariableValue withValue(Object value) {
    this.value = value;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof VariableValue)) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    VariableValue other = (VariableValue) obj;
    return new EqualsBuilder()
      .append(id, other.getId())
      .append(value, other.getValue())
      .isEquals();
  }

  @Override
  public int hashCode() {
    return (id != null ? id.hashCode() : 0) * 31 + (value != null ? value.hashCode() : 0);
  }

  @Override
  public String toString() {
    return "{\"id\":\"" + id + "\",\"value\":\"" + value + "\"}";
  }

}
