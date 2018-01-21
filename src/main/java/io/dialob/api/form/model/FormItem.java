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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Value.Immutable
@Value.Modifiable
@JsonSerialize(as = ImmutableFormItem.class)
@JsonDeserialize(as = ImmutableFormItem.class)
@Gson.TypeAdapters
@JsonIgnoreProperties({"style", "options"})
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public interface FormItem extends Serializable {

  @NotNull
  String getId();

//  "text",
//   "boolean",
//   "list",
//   "date",
//   "time",
//   "number",
//   "decimal",
//   "multichoice"

  @NotNull
  String getType();

  @Nonnull
  Map<String, String> getLabel();

  @Nonnull
  Map<String, String> getDescription();

  @Nullable
  String getRequired();

  @Nullable
  Boolean getReadOnly();

  @Nonnull
  List<String> getItems();

  @Nonnull
  List<String> getClassName();

  @Nullable
  String getActiveWhen();

  @Nonnull
  List<Validation> getValidations();

  @Nullable
  String getValueSetId();

  @Nullable
  Object getDefaultValue();
}
