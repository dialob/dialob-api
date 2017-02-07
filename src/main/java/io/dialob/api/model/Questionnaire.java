package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Questionnaire extends Document {

  @JsonProperty("answers")
  private List<Answer> answers = new ArrayList<>();

  @JsonProperty("tables")
  private List<Table> tables = new ArrayList<>();

  @JsonProperty("context")
  private List<ContextValue> contextValues = new ArrayList<>();

  @JsonProperty("activeItem")
  private String activeItem;

  @JsonProperty("metadata")
  @Valid
  @NotNull
  private Metadata metadata;

  public static class Metadata implements Serializable {

    public enum Status {
      NEW,
      OPEN,
      COMPLETED
    }

    @JsonProperty("formId")
    @NotNull
    private String formId;

    @JsonProperty("formRev")
    private String formRev;

    @JsonProperty("created")
    private Instant created;

    @JsonProperty("lastAnswer")
    private Instant lastAnswer;

    @JsonProperty("label")
    private String label;

    @JsonProperty("submitUrl")
    private String submitUrl;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("language")
    private String language;

    public Metadata withFormRev(String formRev) {
      this.formRev = formRev;
      return this;
    }

    public Metadata withFormId(String formId) {
      this.formId = formId;
      return this;
    }

    public Metadata withCreated(Instant created) {
      this.created = created;
      return this;
    }

    public Metadata withLastAnswer(Instant lastAnswer) {
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

    public Metadata withLanguage(String language) {
      this.language = language;
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

    public void setCreated(Instant created) {
      this.created = created;
    }

    public Instant getCreated() {
      return created;
    }

    public Instant getLastAnswer() {
      return lastAnswer;
    }

    public void setLastAnswer(Instant lastAnswer) {
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

    public String getLanguage() {
      return language;
    }

    public void setLanguage(String language) {
      this.language = language;
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

  public List<ContextValue> getContextValues() {
    return contextValues;
  }

  public void setContextValues(List<ContextValue> contextValues) {
    this.contextValues = contextValues;
  }

  public String getActiveItem() {
    return activeItem;
  }

  public void setActiveItem(String activeItem) {
    this.activeItem = activeItem;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

}
