/*
 * Copyright 2018 ReSys OÜ
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
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public interface ServiceCall extends Serializable {

  @NotNull
  String getId();

  @NotNull
  String getServiceId();

  @Valid
  List<QueryParameter> getQueryParameters();

  @NotNull
  @Valid
  List<OutputVariable> getOutputVariables();

  /**
   * Service input
   * variable defines name of query parameter and expression is assigned value
   */
  @Value.Immutable
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
  @Value.Immutable
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
