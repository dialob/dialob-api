package io.dialob.api.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionnaireTest {

  @Test
  public void gsonShouldSerializeCompatibleJson() {
    Questionnaire questionnaire = QuestionnaireFactory.questionnaire("12","123");
    Gson gson = new GsonBuilder()
      .registerTypeAdapterFactory(new GsonAdaptersQuestionnaire())
      .create();
    String json = gson.toJson(questionnaire);
    Assert.assertEquals("{\"_id\":\"12\",\"metadata\":{\"formId\":\"123\"}}", json);
  }

}
