package io.dialob.api.form.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableServiceCall.class)
@JsonDeserialize(as = ImmutableServiceCall.class)
@Gson.TypeAdapters
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ServiceCall extends Serializable {

  @NotNull
  String getId();

  @NotNull
  String getServiceId();

  @Valid
  List<QueryParameter> getQueryParameters();

  @NotNull
  @Valid
  List<OutputVariable> getOutputVariable();

  /**
   * Service input
   * variable defines name of query parameter and expression is assigned value
   */
  @JsonSerialize(as = ImmutableServiceCall.QueryParameter.class)
  @JsonDeserialize(as = ImmutableServiceCall.QueryParameter.class)
  @Gson.TypeAdapters
  @JsonInclude(JsonInclude.Include.NON_NULL)
  interface QueryParameter extends Serializable {

    @NotNull
    String getParameter();

    @NotNull
    String getExpression();

  }

  /**
   * Service output
   * variable defines name target of variable to which resolved value is assigned
   * expression is XPath, JSONPointer or similar that extracts result from response
   */
  @JsonSerialize(as = ImmutableServiceCall.OutputVariable.class)
  @JsonDeserialize(as = ImmutableServiceCall.OutputVariable.class)
  @Gson.TypeAdapters
  @JsonInclude(JsonInclude.Include.NON_NULL)
  interface OutputVariable extends Serializable {

    @NotNull
    String getType();

    @NotNull
    String getPath();

    @NotNull
    String getVariable();

  }

}
