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
package io.dialob.api.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableErrors.class)
@JsonDeserialize(as = ImmutableErrors.class)
@Gson.TypeAdapters
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public abstract class Errors implements Serializable {

  @ApiModelProperty(notes = "error timestamp")
  @Nullable
  @Value.Default
  public Date getTimestamp() {
    return new Date();
  }

  @ApiModelProperty(notes = "HTTP status code", example = "403")
  @Nullable
  public abstract Integer getStatus();

  @Nullable
  public abstract String getError();

  @Nullable
  public abstract String getMessage();

  @ApiModelProperty(notes = "Java stacktrace, if server is configured to send one.")
  @Nullable
  public abstract String getTrace();

  @Nullable
  public abstract String getPath();

  @ApiModelProperty(notes = "List of identified errors in entity")
  @Nullable
  public abstract List<Error> getErrors();

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Value.Immutable
  @JsonSerialize(as = ImmutableErrors.Error.class)
  @JsonDeserialize(as = ImmutableErrors.Error.class)
  @Gson.TypeAdapters
  public interface Error extends Serializable {

    @ApiModelProperty(notes = "Error classifying code")
    @Nullable
    String getCode();

    @ApiModelProperty(notes = "Javascript path notation to entity attribute")
    @Nullable
    String getContext();

    @ApiModelProperty(notes = "Invalid value on entity attribute")
    @Nullable
    Object getRejectedValue();

    @ApiModelProperty(notes = "Error description")
    @Nullable
    String getError();
  }
}
