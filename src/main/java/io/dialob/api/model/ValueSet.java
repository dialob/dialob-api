/**
 * Copyright 2017 ReSys OÜ
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.dialob.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class ValueSet implements Serializable {

  private String id;

  private List<Entry> entries;

  public ValueSet() {
  }

  public ValueSet(String id, List<Entry> entries) {
    this.id = id;
    this.entries = entries;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

  public static class Entry implements Serializable, Cloneable {

    private String key;

    private String value;

    public Entry() {}

    public Entry(String key) {
      this(key,key);
    }

    public Entry(String key, String value) {
      if (key == null) {
        throw new IllegalArgumentException("key may not be null");
      }
      if (value == null) {
        throw new IllegalArgumentException("value may not be null");
      }
      this.key = key;
      this.value = value;
    }

    public String getKey() {
      return key;
    }

    public String getValue() {
      return value;
    }

    @Override
    public int hashCode() {
      return key.hashCode() * 31 + value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (obj instanceof Entry) {
        Entry other = (Entry) obj;
        return key.equals(other.key) && value.equals(other.value);
      }
      return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      return this;
    }

    @Override
    public String toString() {
      return new ToStringBuilder(this)
        .append("key",key)
        .append("value",value)
        .build();
    }
  }

}
