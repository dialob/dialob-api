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


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question implements Serializable {

  private String id;

  private String label;

  private String type;

  private Boolean inactive;

  private List<String> className;

  private Object value;

  private boolean readOnly;

  private List<String> items;

  private String activeItem;

  private List<String> availableItems;

  private Set<Action.Type> allowedActions;

  private boolean answered;

  private String valueSetId;

  private Map<String, Object> props;

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getInactive() {
    return inactive;
  }

  public void setInactive(Boolean inactive) {
    this.inactive = inactive;
  }

  public List<String> getClassName() {
    return className;
  }

  public void setClassName(List<String> className) {
    this.className = className;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
  }

  public void setActiveItem(String activeItem) {
    this.activeItem = activeItem;
  }

  public String getActiveItem() {
    return activeItem;
  }

  public void setAvailableItems(List<String> availableItems) {
    this.availableItems = availableItems;
  }

  public List<String> getAvailableItems() {
    return availableItems;
  }

  public void setAnswered(boolean answered) {
    this.answered = answered;
  }

  public boolean isAnswered() {
    return answered;
  }

  public Set<Action.Type> getAllowedActions() {
    return allowedActions;
  }

  public void setAllowedActions(Set<Action.Type> allowedActions) {
    this.allowedActions = allowedActions;
  }

  public String getValueSetId() {
    return valueSetId;
  }

  public void setValueSetId(String valueSetId) {
    this.valueSetId = valueSetId;
  }

  public Map<String, Object> getProps() {
    return props;
  }

  public void setProps(Map<String, Object> props) {
    this.props = props;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("id", id)
      .append("type", type)
      .append("inactive", inactive)
      .append("label", label)
      .append("className", className)
      .append("value", value)
      .append("readOnly", readOnly)
      .append("items", items)
      .append("activeItem", activeItem)
      .append("allowedActions", allowedActions)
      .append("valueSetId", valueSetId)
      .append("answered", answered)
      .build();
  }
}
