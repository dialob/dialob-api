package io.dialob.api.form.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableExpressionCompilerError.class)
@JsonDeserialize(as = ImmutableExpressionCompilerError.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE, jdkOnly = true)
public interface ExpressionCompilerError extends Serializable {
  enum Type {
    VISIBILITY,
    VALIDATION,
    REQUIREMENT,
    VARIABLE,
    GENERAL
  }

  String getItemId();

  String getMessage();

  Type getType();

  Optional<Integer> getStartIndex();

  Optional<Integer> getEndIndex();

  Optional<Integer> getIndex();

}
