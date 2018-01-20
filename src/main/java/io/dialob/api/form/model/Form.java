/*
 * Copyright 2018 ReSys OÜ
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableForm.class)
@JsonDeserialize(as = ImmutableForm.class)
@Gson.TypeAdapters(emptyAsNulls = true)
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"saving","rules","updated","failed", "serviceCalls"})
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
  @Nonnull
  Map<String, FormItem> getData();

  @Valid
  @NotNull
  Metadata getMetadata();

  @Valid
  @NotNull
  List<Variable> getVariables();

  @Valid
  @Nonnull
  Map<String, Form> getNamespaces();

  @Valid
  @Nonnull
  List<ValueSet> getValueSets();

  @Value.Immutable
  @JsonSerialize(as = ImmutableForm.Metadata.class)
  @JsonDeserialize(as = ImmutableForm.Metadata.class)
  @Gson.TypeAdapters(emptyAsNulls = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
  interface Metadata extends Serializable {

    @Nullable String getLabel();

    @Nullable Date getCreated();

    @Nullable Date getLastSaved();

    @Nullable Boolean getValid();

    @Nullable String getCreator();

    @Nullable String getTenantId();

    @Nullable String getSavedBy();

    @Nonnull
    Set<String> getLabels();

    @Nullable String getDefaultSubmitUrl();

    @Nonnull
    Set<String> getLanguages();

    @JsonInclude
    @JsonAnyGetter
    @AllowNulls
    Map<String,Object> getAdditionalProperties();
  }
}
