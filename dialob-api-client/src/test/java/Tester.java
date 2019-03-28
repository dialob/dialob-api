import io.dialob.api.client.DialobFormServiceApi;
import io.dialob.api.client.okhttp.ApiClient;
import io.dialob.api.form.model.Form;

public class Tester {
  public static void main(String[] args) {

    ApiClient apiClient = new ApiClient("ApiKey");
    apiClient.setBasePath("https://demo.dialob.io/api");
    apiClient.setApiKey("localhost-test:secret-api-key");

    DialobFormServiceApi dialobFormServiceApi = apiClient.buildClient(DialobFormServiceApi.class);
    Form form = dialobFormServiceApi.getFormUsingGET("inRuleTest", "LATEST");
    System.out.println(form);
  }
}
