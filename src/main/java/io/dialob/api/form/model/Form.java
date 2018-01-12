package io.dialob.api.form.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dialob.api.annotation.AllowNulls;
import org.immutables.gson.Gson;
import org.immutables.value.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableForm.class)
@JsonDeserialize(as = ImmutableForm.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public interface Form extends Serializable {

  @JsonProperty("_id")
  @Gson.Named("_id")
  @Id
  @Nullable
  String getId();

  @JsonProperty("_rev")
  @Gson.Named("_rev")
  @Version
  @Nullable
  String getRev();

  @Valid
  @Nullable
  Map<String, FormItem> getData();

  @Nullable
  HashMap<String, ServiceCall> getServiceCalls();

  @Valid
  @NotNull
  Metadata getMetadata();

  @Valid
  @Nullable
  List<Variable> getVariables();

  @Valid
  @Nullable
  HashMap<String, Form> getNamespaces();

  @Valid
  @Nullable
  List<ValueSet> getValueSets();

  @Value.Immutable
  @JsonSerialize(as = ImmutableForm.Metadata.class)
  @JsonDeserialize(as = ImmutableForm.Metadata.class)
  @Gson.TypeAdapters
  @JsonIgnoreProperties(ignoreUnknown = true)
  interface Metadata extends Serializable {

    @Nullable String getLabel();

    @Nullable Date getCreated();

    @Nullable Date getLastSaved();

    @Nullable Boolean getValid();

    @Nullable String getCreator();

    @Nullable String getTenantId();

    @Nullable String getSavedBy();

    @Nullable Set<String> getLabels();

    @Nullable String getDefaultSubmitUrl();

    @Nullable Set<String> getLanguages();

    @JsonInclude
    @JsonAnyGetter
    @AllowNulls
    Map<String,Object> getAdditionalProperties();
  }
}
