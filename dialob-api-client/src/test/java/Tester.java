import io.dialob.api.client.DialobFormServiceApi;
import io.dialob.api.client.DialobQuestionnaireServiceApi;
import io.dialob.api.client.okhttp.ApiClient;
import io.dialob.api.form.model.Form;
import io.dialob.api.questionnaire.model.Questionnaire;
import io.dialob.api.questionnaire.model.QuestionnaireListItem;

import java.util.List;

public class Tester {
  public static void main(String[] args) {

    ApiClient apiClient = new ApiClient("ApiKey");
    apiClient.setBasePath("https://test.dialob.io/api");
    apiClient.setApiKey("3eWxtU1dS02mgRzrmEfSwpL/9wL3/OZWUQdcSDsV");

    DialobQuestionnaireServiceApi dialobQuestionnaireServiceApi = apiClient.buildClient(DialobQuestionnaireServiceApi.class);
    DialobFormServiceApi dialobFormServiceApi = apiClient.buildClient(DialobFormServiceApi.class);
    final List<QuestionnaireListItem> questionnaires = dialobQuestionnaireServiceApi.getQuestionnairesUsingGET();
    System.out.println(questionnaires);
  }
}
