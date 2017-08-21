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
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question implements Serializable {

  private String id;

  private String label;

  private String description;

  private String type;

  private Boolean disabled;

  private List<String> className;

  private Object value;

  private List<String> items;

  private String activeItem;

  private List<String> availableItems;

  private Set<Action.Type> allowedActions;

  private Boolean answered;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getDisabled() {
    return disabled;
  }

  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
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
    return answered != null && answered;
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
      .append("disabled", disabled)
      .append("label", label)
      .append("description", description)
      .append("className", className)
      .append("value", value)
      .append("items", items)
      .append("activeItem", activeItem)
      .append("allowedActions", allowedActions)
      .append("valueSetId", valueSetId)
      .append("answered", answered)
      .build();
  }
}
