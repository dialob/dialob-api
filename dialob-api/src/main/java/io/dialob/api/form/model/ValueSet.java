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

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Value.Immutable
@Value.Modifiable
@JsonSerialize(as = ImmutableValueSet.class)
@JsonDeserialize(as = ImmutableValueSet.class)
@Gson.TypeAdapters(emptyAsNulls = true)
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE, jdkOnly = true)
public interface ValueSet extends Serializable {

  @NotNull
  String getId();

  List<Entry> getEntries();

  @Value.Immutable
  @Value.Style(typeImmutable = "ImmutableValueSet*", typeModifiable = "ModifiableValueSet*")
  @Value.Modifiable
  @JsonSerialize(as = ImmutableValueSetEntry.class)
  @JsonDeserialize(as = ImmutableValueSetEntry.class)
  @Gson.TypeAdapters(emptyAsNulls = true)
  interface Entry extends Serializable {

    @NotNull
    String getId();

    Map<String, String> getLabel();
  }
}
