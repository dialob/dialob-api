package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Items implements Serializable {

  private String activeItem;

  private List<String> items;

  private List<String> availableItems;

  public String getActiveItem() {
    return activeItem;
  }

  public void setActiveItem(String activeItem) {
    this.activeItem = activeItem;
  }

  public List<String> getAvailableItems() {
    return availableItems;
  }

  public void setAvailableItems(List<String> availableItems) {
    this.availableItems = availableItems;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public String toString() {
    return new ToStringBuilder(this)
      .append("activeItem", activeItem)
      .append("availableItems", availableItems)
      .append("items", items)
      .build();
  }
}
