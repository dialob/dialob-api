/*
 * Copyright 2017 ReSys OÜ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContextValue implements Serializable {
  private String id;

  private String value;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ContextValue withId(String id) {
    this.id = id;
    return this;
  }

  public ContextValue withValue(String value) {
    this.value = value;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Answer)) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    Answer other = (Answer) obj;
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
