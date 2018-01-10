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
package io.dialob.api.proto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableValueSet.class)
@JsonDeserialize(as = ImmutableValueSet.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public interface ValueSet extends Serializable {

  String getId();

  @Nullable List<Entry> getEntries();

  @Value.Immutable
  @JsonSerialize(as = ImmutableEntry.class)
  @JsonDeserialize(as = ImmutableEntry.class)
  @Gson.TypeAdapters
  @JsonInclude(JsonInclude.Include.NON_NULL)
  interface Entry extends Serializable {

    String getKey();

    @Nullable String getValue();

  }

}