/*
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

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class QuestionTest {
  @Test
  public void shouldDeserializePropsToMap() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Question question = objectMapper.readValue("{\"props\":{\"extraProp\":\"extraValue\"}}", Question.class);
    assertEquals("extraValue", question.getProps().get("extraProp"));
    question = objectMapper.readValue("{\"props\":{\"extraProp\":1}}", Question.class);
    assertEquals(1, question.getProps().get("extraProp"));
    question = objectMapper.readValue("{\"props\":{\"extraProp\":1.0}}", Question.class);
    assertEquals(1D, question.getProps().get("extraProp"));
    question = objectMapper.readValue("{\"props\":{\"extraProp\":false}}", Question.class);
    assertEquals(false, question.getProps().get("extraProp"));
    question = objectMapper.readValue("{\"props\":{\"extraProp\":true}}", Question.class);
    assertEquals(true, question.getProps().get("extraProp"));
    question = objectMapper.readValue("{\"props\":{\"extraProp\":[]}}", Question.class);
    assertEquals(Collections.emptyList(), question.getProps().get("extraProp"));
    question = objectMapper.readValue("{}", Question.class);
    assertEquals(null, question.getProps());
  }
  @Test
  public void shouldSerializeMapToProps() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Question question = new Question();
    question.setProps(new HashMap<String,Object>());
    question.getProps().put("extraProp","extraValue");
    assertEquals("{\"answered\":false,\"props\":{\"extraProp\":\"extraValue\"}}", objectMapper.writeValueAsString(question));
    question = new Question();
    assertEquals("{\"answered\":false}", objectMapper.writeValueAsString(question));
  }

}
