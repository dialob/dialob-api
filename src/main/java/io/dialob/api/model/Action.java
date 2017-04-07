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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action implements Serializable {

  public enum Type {
    NEW_QUESTION,
    NEW_ERROR,
    REMOVE_ERROR,
    REMOVE_QUESTION,
    UPDATE_QUESTION,
    REMOVE_ALL,
    ANSWER_QUESTION,
    NEXT_PAGE,
    PREVIOUS_PAGE,
    GOTO_PAGE,
    COMPLETE_QUESTIONNAIRE,
    QUESTIONNAIRE_NOT_FOUND,
    WILL_PASSIVATE,
    ACTIVATED,
    NOTIFY_SERVER_ERROR,
    WAKE_UP,
    NEW_VALUE_SET,
    UPDATE_VALUE_SET,
    REMOVE_VALUE_SET,
    SERVICE_CALL_RESPONSE,
    ADD_ROW,
    ADD_ROWS,
    DELETE_ROW,
    SET_VARIABLE_VALUE,
    SET_VARIABLE_FAILED
  }

  private String id;

  private String message;

  private String trace;

  private Type type;

  private Question question;

  private Error error;

  private Object answer;

  private String questionId;

  private String questionnaireId;

  private String page;

  @JsonIgnore
  private Boolean serverEvent;

  private String resourceId;

  private String formId;

  private String valueSetId;

  private List<String> ids;

  private Object value;

  private ValueSet valueSet;

  public void setValueSet(ValueSet valueSet) {
    this.valueSet = valueSet;
  }

  public ValueSet getValueSet() {
    return valueSet;
  }

  public void setValueSetId(String valueSetId) {
    this.valueSetId = valueSetId;
  }

  public String getValueSetId() {
    return valueSetId;
  }

  public String getFormId() {
    return formId;
  }

  public void setFormId(String formId) {
    this.formId = formId;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public void setError(Error error) {
    this.error = error;
  }

  public void setAnswer(Object answer) {
    this.answer = answer;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public String getPage() {
    return page;
  }

  public Type getType() {
    return type;
  }

  public String getQuestionId() {
    return questionId;
  }

  public Question getQuestion() {
    return question;
  }

  public Error getError() {
    return error;
  }

  public String getId() {
    return id;
  }

  public Object getAnswer() {
    return answer;
  }

  @JsonIgnore
  public Boolean getServerEvent() {
    return serverEvent;
  }

  @JsonIgnore
  public void setServerEvent(Boolean serverEvent) {
    this.serverEvent = serverEvent;
  }

  public String getQuestionnaireId() {
    return questionnaireId;
  }

  public void setQuestionnaireId(String questionnaireId) {
    this.questionnaireId = questionnaireId;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setTrace(String trace) {
    this.trace = trace;
  }

  public String getTrace() {
    return trace;
  }

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("type", type)
      .append("questionId", questionId)
      .append("question", question)
      .append("answer", answer)
      .append("id", id)
      .append("serverEvent", serverEvent)
      .append("questionnaireId", questionnaireId)
      .append("resourceId", resourceId)
      .append("valueSet", valueSet)
      .append("valueSetId", valueSetId)
      .append("value", value)
      .append("error", error)
      .append("ids", ids)
      .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Action)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Action other = (Action) obj;
    return new EqualsBuilder()
      .append(id, other.id)
      .append(type, other.type)
      .append(answer, other.answer)
      .append(questionId, other.questionId)
      .append(question, other.question)
      .append(serverEvent, other.serverEvent)
      .append(questionnaireId, other.questionnaireId)
      .append(resourceId, other.resourceId)
      .append(page, other.page)
      .append(valueSet, other.valueSet)
      .append(valueSetId, other.valueSetId)
      .append(value, other.value)
      .append(error, other.error)
      .append(ids, other.ids)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(id)
      .append(type)
      .append(answer)
      .append(questionId)
      .append(question)
      .append(serverEvent)
      .append(questionnaireId)
      .append(resourceId)
      .append(page)
      .append(valueSet)
      .append(valueSetId)
      .append(value)
      .append(error)
      .append(ids)
      .toHashCode();
  }

}
