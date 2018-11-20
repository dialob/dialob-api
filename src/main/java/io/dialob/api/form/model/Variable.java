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

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Value.Immutable
@Value.Modifiable
@JsonSerialize(as = ImmutableVariable.class)
@JsonDeserialize(as = ImmutableVariable.class)
@Gson.TypeAdapters
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Variable extends Serializable {

  @NotNull
  @Value.Parameter
  String getName();

  @Nullable
  @Value.Parameter
  String getExpression();

  @Nullable
  Object getDefaultValue();

  /**
   * @return true when this is context variable
   */
  @Nullable
  Boolean getContext();

  /**
   * @return true when context variable is confidential and should not be sent to client.
   */
  @Nullable
  Boolean getConfidential();

  @Nullable
  String getContextType();

}
