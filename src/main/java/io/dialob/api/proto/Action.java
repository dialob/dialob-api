package io.dialob.api.proto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dialob.api.questionnaire.model.Error;
import io.dialob.api.questionnaire.model.Question;
import io.dialob.api.questionnaire.model.ValueSet;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableAction.class)
@JsonDeserialize(as = ImmutableAction.class)
@Gson.TypeAdapters
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Action extends Serializable {

  public enum Type {
    ANSWER(true),
    NEXT(true),
    PREVIOUS(true),
    GOTO(true),
    COMPLETE(true),
    ADD_ROW(true),
    DELETE_ROW(true),
    RESET(false),
    QUESTION(false),
    REMOVE_QUESTIONS(false),
    ERROR(false),
    REMOVE_ERROR(false),
    VALUE_SET(false),
    REMOVE_VALUE_SETS(false),
    NOT_FOUND(false),
    SERVER_ERROR(false),
    ROWS(false),
    SET_VALUE(false),
    SET_FAILED(false);

    final boolean clientAction;

    Type(boolean clientAction) {
      this.clientAction = clientAction;
    }
  }

  Type getType();

  @Nullable
  String getId();

  @Nullable
  String getMessage();

  @Nullable
  String getTrace();

  @Nullable
  Question getQuestion();

  @Nullable
  Error getError();

  @Nullable
  Object getAnswer();

  @Nullable
  List<String> getIds();

  @Nullable
  Object getValue();

  @Nullable
  ValueSet getValueSet();

  @JsonIgnore
  @Nullable
  Boolean getServerEvent();

  @JsonIgnore
  @Nullable
  String getResourceId();

}
