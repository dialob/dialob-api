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
import io.dialob.api.questionnaire.model.Error;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Questionnaire extends Document {

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

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Metadata implements Serializable {

    public enum Status {
      NEW,
      OPEN,
      COMPLETED
    }

    public enum Reason {
      SKIPPED,
      CANCELLED
    }

    @JsonProperty("formId")
    @NotNull
    private String formId;

    @JsonProperty("formRev")
    private String formRev;

    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("created")
    @CreatedDate
    private Date created;

    @JsonProperty("lastAnswer")
    private Date lastAnswer;

    @JsonProperty("label")
    private String label;

    @JsonProperty("submitUrl")
    private String submitUrl;

    @JsonProperty("status")
    private Status status;

    /**
     * Completion reason, null if normally completed.
     */
    @JsonProperty("reason")
    private Reason reason;

    @JsonProperty("language")
    private String language;

    /**
     * userId of document owner
     */
    @JsonProperty("owner")
    private String owner;

    /**
     * userId of one who created questionnaire
     */
    @JsonProperty("creator")
    private String creator;

    @JsonInclude
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Metadata withFormId(String formId) {
      this.formId = formId;
      return this;
    }

    public Metadata withFormRev(String formRev) {
      this.formRev = formRev;
      return this;
    }

    public Metadata withCreated(Date created) {
      this.created = created;
      return this;
    }

    public Metadata withTenantId(String tenantId) {
      this.tenantId = tenantId;
      return this;
    }

    public Metadata withLastAnswer(Date lastAnswer) {
      this.lastAnswer = lastAnswer;
      return this;
    }

    public Metadata withLabel(String label) {
      this.label = label;
      return this;
    }

    public Metadata withSubmitUrl(String submitUrl) {
      this.submitUrl = submitUrl;
      return this;
    }

    public Metadata withStatus(Status status) {
      this.status = status;
      return this;
    }

    public Metadata withReason(Reason reason) {
      this.reason = reason;
      return this;
    }

    public Metadata withLanguage(String language) {
      this.language = language;
      return this;
    }

    public Metadata withOwner(String owner) {
      this.owner = owner;
      return this;
    }

    public Metadata withCreator(String creator) {
      this.creator = creator;
      return this;
    }


    public String getFormRev() {
      return formRev;
    }

    public void setFormRev(String formRev) {
      this.formRev = formRev;
    }

    public String getFormId() {
      return formId;
    }

    public void setFormId(String formId) {
      this.formId = formId;
    }

    public void setCreated(Date created) {
      this.created = created;
    }

    public Date getCreated() {
      return created;
    }

    public String getTenantId() {
      return tenantId;
    }

    public void setTenantId(String tenantId) {
      this.tenantId = tenantId;
    }

    public Date getLastAnswer() {
      return lastAnswer;
    }

    public void setLastAnswer(Date lastAnswer) {
      this.lastAnswer = lastAnswer;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getSubmitUrl() {
      return submitUrl;
    }

    public void setSubmitUrl(String submitUrl) {
      this.submitUrl = submitUrl;
    }

    public Status getStatus() {
      return status;
    }

    public void setStatus(Status status) {
      this.status = status;
    }

    public Reason getReason() {
      return reason;
    }

    public void setReason(Reason reason) {
      this.reason = reason;
    }

    public String getLanguage() {
      return language;
    }

    public void setLanguage(String language) {
      this.language = language;
    }

    public String getOwner() {
      return owner;
    }

    public void setOwner(String owner) {
      this.owner = owner;
    }

    public String getCreator() {
      return creator;
    }

    public void setCreator(String creator) {
      this.creator = creator;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
      return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
      additionalProperties.put(name, value);
    }
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


}
