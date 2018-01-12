package io.dialob.api.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public interface Metadata extends Serializable {

  String getDescription();

  @NotNull
  @Size(min = 1)
  String getLabel();

  Date getCreated();

  Date getLastSaved();

  Boolean getValid();

}
