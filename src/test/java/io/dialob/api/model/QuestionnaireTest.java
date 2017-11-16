package io.dialob.api.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionnaireTest {

  @Test
  public void gsonShouldSerializeCompatibleJson() {
    Questionnaire questionnaire = new Questionnaire();
    Gson gson = new GsonBuilder().create();
    String json = gson.toJson(questionnaire);
    Assert.assertEquals("{\"answers\":[],\"tables\":[],\"context\":[]}", json);
  }

}
