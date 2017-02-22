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
}
