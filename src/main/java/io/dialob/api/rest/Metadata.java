package io.dialob.api.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Value.Immutable
@JsonSerialize(as = ImmutableMetadata.class)
@JsonDeserialize(as = ImmutableMetadata.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL)
public interface Metadata extends Serializable {

  @Nullable
  String getDescription();

  @NotNull
  @Size(min = 1)
  @Nonnull
  String getLabel();

  @Nullable
  Date getCreated();

  @Nullable
  Date getLastSaved();

  @Nullable
  Boolean getValid();

}
