package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

public class QuestionnaireMetadata implements Serializable {

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

  public QuestionnaireMetadata withFormRev(String formRev) {
    this.formRev = formRev;
    return this;
  }

  public QuestionnaireMetadata withFormId(String formId) {
    this.formId = formId;
    return this;
  }

  public QuestionnaireMetadata withCreated(Instant created) {
    this.created = created;
    return this;
  }

  public QuestionnaireMetadata withLastAnswer(Instant lastAnswer) {
    this.lastAnswer = lastAnswer;
    return this;
  }

  public QuestionnaireMetadata withLabel(String label) {
    this.label = label;
    return this;
  }

  public QuestionnaireMetadata withSubmitUrl(String submitUrl) {
    this.submitUrl = submitUrl;
    return this;
  }

  public QuestionnaireMetadata withStatus(Status status) {
    this.status = status;
    return this;
  }

  public QuestionnaireMetadata withLanguage(String language) {
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
