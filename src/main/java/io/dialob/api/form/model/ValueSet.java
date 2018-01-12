package io.dialob.api.form.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableValueSet.class)
@JsonDeserialize(as = ImmutableValueSet.class)
@Gson.TypeAdapters
public interface ValueSet extends Serializable {

  String getId();

  List<Entry> getEntries();

  @Value.Immutable
  @JsonSerialize(as = ImmutableValueSet.Entry.class)
  @JsonDeserialize(as = ImmutableValueSet.Entry.class)
  @Gson.TypeAdapters
  interface Entry extends Serializable {

    String getId();

    Map<String, String> getLabel();
  }
}
