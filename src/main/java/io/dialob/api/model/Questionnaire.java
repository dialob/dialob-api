/*
 * Copyright 2017 ReSys OÜ
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
package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dialob.api.annotation.AllowNulls;
import io.dialob.api.questionnaire.model.Error;
import org.immutables.gson.Gson;
import org.immutables.value.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Value.Immutable
@JsonSerialize(as = ImmutableQuestionnaire.class)
@JsonDeserialize(as = ImmutableQuestionnaire.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public interface Questionnaire extends Serializable {

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

  @Nullable
  List<Answer> getAnswers();

  @Nullable
  List<Table> getTables();

  @Nullable
  List<ContextValue> getContext();

  @Nullable
  String getActiveItem();

  @Nullable
  List<Error> getErrors();

  @Nullable
  List<VariableValue> getVariableValues();

  @Valid
  @NotNull
  Metadata getMetadata();

  @Value.Immutable
  @JsonSerialize(as = ImmutableMetadata.class)
  @JsonDeserialize(as = ImmutableMetadata.class)
  @Gson.TypeAdapters
  @JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
  interface Metadata extends Serializable {

    enum Status {
      NEW,
      OPEN,
      COMPLETED
    }

    enum Reason {
      SKIPPED,
      CANCELLED
    }

    String getFormId();

    @Nullable
    String getFormRev();

    @Nullable
    String getTenantId();

    @Nullable
    Date getCreated();

    @Nullable
    Date getLastAnswer();

    @Nullable
    String getLabel();

    @Nullable
    String getSubmitUrl();

    @Nullable
    Status getStatus();

    /**
     * Completion reason, null if normally completed.
     */
    @Nullable
    Reason getReason();

    @Nullable
    String getLanguage();

    /**
     * userId of document owner
     */
    @Nullable
    String getOwner();

    /**
     * userId of one who created questionnaire
     */
    @Nullable
    String getCreator();

    @JsonInclude
    @JsonAnyGetter
    @AllowNulls
    @Gson.Ignore
    Map<String, Object> getAdditionalProperties();
  }
}
