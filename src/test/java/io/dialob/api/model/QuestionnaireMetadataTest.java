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
