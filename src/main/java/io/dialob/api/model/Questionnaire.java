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

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dialob.api.annotation.AllowNulls;
import io.dialob.api.proto.ImmutableActions;
import io.dialob.api.questionnaire.model.Error;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.immutables.gson.Gson;
import org.immutables.value.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Questionnaire implements Serializable {
  @JsonProperty("_id")
  @Id
  private String _id;

  @JsonProperty("_rev")
  @Version
  private String _rev;

  public Questionnaire withId(String id) {
    this._id = id;
    return this;
  }

  public Questionnaire withRev(String rev) {
    this._rev = rev;
    return this;
  }

  @JsonIgnore
  public String getId() {
    return _id;
  }

  @JsonIgnore
  public void setId(String _id) {
    this._id = _id;
  }

  @JsonIgnore
  public String getRev() {
    return _rev;
  }

  @JsonIgnore
  public void setRev(String _rev) {
    this._rev = _rev;
  }

  @JsonProperty("answers")
  private List<Answer> answers = new ArrayList<Answer>();

  @JsonProperty("tables")
  private List<Table> tables = new ArrayList<Table>();

  @JsonProperty("context")
  private List<ContextValue> context = new ArrayList<ContextValue>();

  @JsonProperty("activeItem")
  private String activeItem;

  @JsonProperty("errors")
  private List<Error> errors;

  @JsonProperty("variableValues")
  private List<VariableValue> variableValues;

  @JsonProperty("metadata")
  @Valid
  @NotNull
  private Metadata metadata;

  @Value.Immutable
  @JsonSerialize(as = ImmutableMetadata.class)
  @JsonDeserialize(as = ImmutableMetadata.class)
  @Gson.TypeAdapters
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public interface Metadata extends Serializable {

    public enum Status {
      NEW,
      OPEN,
      COMPLETED
    }

    public enum Reason {
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
    Map<String, Object> getAdditionalProperties();

  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public List<Table> getTables() {
    return tables;
  }

  public void setTables(List<Table> tables) {
    this.tables = tables;
  }

  @JsonIgnore
  public List<ContextValue> getContextValues() {
    return context;
  }

  @JsonIgnore
  public void setContextValues(List<ContextValue> contextValues) {
    this.context = contextValues;
  }

  public String getActiveItem() {
    return activeItem;
  }

  public void setActiveItem(String activeItem) {
    this.activeItem = activeItem;
  }

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  public List<VariableValue> getVariableValues() {
    return variableValues;
  }

  public void setVariableValues(List<VariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj instanceof Questionnaire) {
      Questionnaire other = (Questionnaire) obj;
      return new EqualsBuilder()
        .append(this._id, other._id)
        .append(this._rev, other._rev)
        .append(this.answers, other.answers)
        .append(this.tables, other.tables)
        .append(this.context, other.context)
        .append(this.activeItem, other.activeItem)
        .append(this.errors, other.errors)
        .append(this.variableValues, other.variableValues)
        .append(this.metadata, other.metadata)
        .append(this.metadata, other.metadata)
        .build();
    }
    return false;
  }

  /*
  private String _id;
  private String _rev;
  private List<Answer> answers = new ArrayList<Answer>();
  private List<Table> tables = new ArrayList<Table>();
  private List<ContextValue> context = new ArrayList<ContextValue>();
  private String activeItem;
  private List<Error> errors;
  private List<VariableValue> variableValues;
  private Metadata metadata;


   */

}
