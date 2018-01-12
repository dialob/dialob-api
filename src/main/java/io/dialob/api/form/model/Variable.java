package io.dialob.api.form.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Value.Immutable
@JsonSerialize(as = ImmutableVariable.class)
@JsonDeserialize(as = ImmutableVariable.class)
@Gson.TypeAdapters
public interface Variable extends Serializable {

  @NotNull
  String getName();

  @Nullable
  String getExpression();

  @Nullable
  Object getDefaultValue();

  @Nullable
  Boolean getContext();

  @Nullable
  String getContextType();

}
