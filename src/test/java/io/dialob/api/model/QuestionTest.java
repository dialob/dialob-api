package io.dialob.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.*;

public class QuestionTest {
  @Test
  public void shouldDeseralizePropsToMap() throws Exception {
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
    assertEquals(null, question.getProps().get("extraProp"));
  }
  @Test
  public void shouldSeralizeMapToProps() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Question question = new Question();
    question.setProps(new HashMap<>());
    question.getProps().put("extraProp","extraValue");
    assertEquals("{\"readOnly\":false,\"answered\":false,\"props\":{\"extraProp\":\"extraValue\"}}", objectMapper.writeValueAsString(question));
  }

}
