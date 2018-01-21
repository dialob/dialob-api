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
package io.dialob.api.questionnaire.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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

@Value.Immutable
@Value.Modifiable
@Value.Style(deepImmutablesDetection = true)
@JsonSerialize(as = ImmutableQuestionnaire.class)
@JsonDeserialize(as = ImmutableQuestionnaire.class)
@Gson.TypeAdapters(emptyAsNulls = true)
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

  @Nonnull
  List<Answer> getAnswers();

  @Nonnull
  List<Table> getTables();

  @Nonnull
  List<ContextValue> getContext();

  @Nullable
  String getActiveItem();

  @Nonnull
  List<Error> getErrors();

  @Nonnull
  List<VariableValue> getVariableValues();

  @Valid
  @NotNull
  Metadata getMetadata();

  @Value.Immutable
  @Value.Modifiable
  @Value.Style(typeImmutable = "ImmutableQuestionnaire*", typeModifiable = "ModifiableQuestionnaire*")
  @JsonSerialize(as = ImmutableQuestionnaireMetadata.class)
  @JsonDeserialize(as = ImmutableQuestionnaireMetadata.class)
  @Gson.TypeAdapters
  @JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
  abstract class Metadata implements Serializable {

    public enum Status {
      NEW,
      OPEN,
      COMPLETED
    }

    public enum Reason {
      SKIPPED,
      CANCELLED
    }

    @NotNull
    public abstract String getFormId();

    @NotNull
    @Value.Default
    public Status getStatus() {
      return Status.NEW;
    }

    @Nullable
    public abstract String getFormRev();

    @Nullable
    public abstract String getTenantId();

    @Nullable
    public abstract Date getCreated();

    @Nullable
    public abstract Date getLastAnswer();

    @Nullable
    public abstract String getLabel();

    @Nullable
    public abstract String getSubmitUrl();

    /**
     * Completion reason, null if normally completed.
     */
    @Nullable
    public abstract Reason getReason();

    @Nullable
    public abstract String getLanguage();

    /**
     * userId of document owner
     */
    @Nullable
    public abstract String getOwner();

    /**
     * userId of one who created questionnaire
     */
    @Nullable
    public abstract String getCreator();

    @JsonInclude
    @JsonAnyGetter
    @AllowNulls
    @Gson.Ignore
    public abstract Map<String, Object> getAdditionalProperties();
  }
}
