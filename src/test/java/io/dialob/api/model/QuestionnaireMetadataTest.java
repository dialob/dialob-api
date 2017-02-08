/**
 * Copyright 2017 ReSys OÜ
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.dialob.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionnaireMetadataTest {
  @Test
  public void shouldDeseralizeUnknownAttributesToAdditionalProperties() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Questionnaire.Metadata metadata = objectMapper.readValue("{\"extraProp\":\"extraValue\"}", Questionnaire.Metadata.class);
    assertTrue(metadata.getAdditionalProperties().size() > 0);
    assertEquals("extraValue", metadata.getAdditionalProperties().get("extraProp"));
  }
  @Test
  public void shouldSeralizeAdditionalPropertiesToJsonAttributes() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Questionnaire.Metadata metadata = new Questionnaire.Metadata();
    metadata.setAdditionalProperty("extraProp","extraValue");
    assertEquals("{\"extraProp\":\"extraValue\"}", objectMapper.writeValueAsString(metadata));
  }
}
