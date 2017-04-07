/**
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document implements Serializable {

  @JsonProperty("_id")
  @Id
  private String _id;

  @JsonProperty("_rev")
  @Version
  private String _rev;

  public Document withId(String id) {
    this._id = id;
    return this;
  }

  public Document withRev(String rev) {
    this._rev = rev;
    return this;
  }

  @JsonIgnore
  public String getId() {
    return _id;
  }

  @JsonIgnore
  public void setId(String _id) {
    this._id = _id;
  }

  @JsonIgnore
  public String getRev() {
    return _rev;
  }

  @JsonIgnore
  public void setRev(String _rev) {
    this._rev = _rev;
  }

  @Override
  public int hashCode() {
    return _id != null ? _id.hashCode() * 31 : 0
      + _rev != null ? _rev.hashCode() : 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !Document.class.isAssignableFrom(obj.getClass())) {
      return false;
    }
    Document document = (Document) obj;
    if (document._id != _id) {
      if (_id == null || !_id.equals(document._id)) {
        return false;
      }
    }
    if (document._rev != _rev) {
      if (_rev == null || !_rev.equals(document._rev)) {
        return false;
      }
    }
    return true;
  }

  public String toString() {
    return "{\"_id\":\"" + _id + "\",\"_rev\":\"" + _rev + "\"}";
  }

}
