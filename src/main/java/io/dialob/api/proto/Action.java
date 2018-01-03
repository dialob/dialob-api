package io.dialob.api.proto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dialob.api.model.Error;
import io.dialob.api.model.Question;
import io.dialob.api.model.ValueSet;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableAction.class)
@JsonDeserialize(as = ImmutableAction.class)
@Gson.TypeAdapters
public interface Action extends Serializable {

  io.dialob.api.model.Action.Type getType();

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
  String getQuestionId();

  @Nullable
  String getQuestionnaireId();

  @Nullable
  String getPage();

  @JsonIgnore
  @Nullable
  Boolean getServerEvent();

  @Nullable
  String getResourceId();

  @Nullable
  String getFormId();

  @Nullable
  String getValueSetId();

  @Nullable
  List<String> getIds();

  @Nullable
  Object getValue();

  @Nullable
  ValueSet getValueSet();

}
