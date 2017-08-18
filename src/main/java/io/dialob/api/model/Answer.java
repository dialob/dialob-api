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
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer implements Serializable {

  private String id;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object value;

  private Date updated;

  private String userId;

  public Answer withId(String id) {
    this.id = id;
    return this;
  }

  public Answer withValue(Object value) {
    this.value = value;
    return this;
  }

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

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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
      .append(updated, other.getUpdated())
      .append(userId, other.getUserId())
      .isEquals();
  }

  @Override
  public int hashCode() {
    return ( ( ( (id != null ? id.hashCode() : 0) * 31
          + (value != null ? value.hashCode() : 0)) * 31
          + (updated != null ? updated.hashCode() : 0)) * 31
          + (userId != null ? userId.hashCode() : 0)) * 31;
  }

  @Override
  public String toString() {
    return "{\"id\":\"" + id + "\"," +
      "\"value\":" + (value == null ? "null" : "\"" + value + "\"") + "," +
      "\"updated\":" + (updated == null ? "null" : "\"" + updated + "\"") + "," +
      "\"userId\":" + (userId == null ? "null" : "\"" + userId + "\"") + "}";
  }
}
