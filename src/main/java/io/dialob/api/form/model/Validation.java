package io.dialob.api.form.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Map;

@Value.Immutable
@JsonSerialize(as = ImmutableValidation.class)
@JsonDeserialize(as = ImmutableValidation.class)
@Gson.TypeAdapters
public interface Validation extends Serializable {

  @Nullable
  Map<String, String> getMessage();

  @Nullable
  String getRule();

}
