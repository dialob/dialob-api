package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;

@Value.Immutable
@JsonSerialize(as = ImmutableVariableValue.class)
@JsonDeserialize(as = ImmutableVariableValue.class)
@Gson.TypeAdapters
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface VariableValue extends Serializable {

  String getId();

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Nullable Object getValue();


}
