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

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableValueSet.class)
@JsonDeserialize(as = ImmutableValueSet.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public interface ValueSet extends Serializable {

  @Nonnull
  String getId();

  @Nonnull
  List<Entry> getEntries();

  @Value.Immutable
  @JsonSerialize(as = ImmutableValueSet.Entry.class)
  @JsonDeserialize(as = ImmutableValueSet.Entry.class)
  @Gson.TypeAdapters
  interface Entry extends Serializable {

    @Nonnull
    String getId();

    @Nonnull
    Map<String, String> getLabel();
  }
}
