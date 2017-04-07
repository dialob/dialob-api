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

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Actions implements Serializable, Cloneable {

  private String prevRev;

  private String nextRev;

  private List<Action> actions;

  public void setPrevRev(String prevRev) {
    this.prevRev = prevRev;
  }

  public void setNextRev(String nextRev) {
    this.nextRev = nextRev;
  }

  public void setActions(List<Action> actions) {
    this.actions = actions;
  }

  public String getPrevRev() {
    return prevRev;
  }

  public String getNextRev() {
    return nextRev;
  }

  public List<Action> getActions() {
    return actions;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("prevRev", prevRev)
      .append("nextRev", nextRev)
      .append("actions", actions)
      .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Actions)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Actions other = (Actions) obj;
    return new EqualsBuilder()
      .append(prevRev, other.prevRev)
      .append(nextRev, other.nextRev)
      .append(actions, other.actions)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(prevRev)
      .append(nextRev)
      .append(actions)
      .toHashCode();
  }

  public Actions withActions(List<Action> filteredActions) {
    try {
      Actions actions = (Actions) this.clone();
      actions.setActions(filteredActions);
      return actions;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }
}
