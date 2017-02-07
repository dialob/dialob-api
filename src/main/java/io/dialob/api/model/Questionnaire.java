package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dialob.api.model.Answer;
import io.dialob.api.model.ContextValue;
import io.dialob.api.model.Table;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
  private QuestionnaireMetadata metadata;

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

  public QuestionnaireMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(QuestionnaireMetadata metadata) {
    this.metadata = metadata;
  }

}
