import io.dialob.api.client.DialobFormServiceApi;
import io.dialob.api.client.DialobFormServiceApiImpl;

public class Tester {
  public static void main(String[] args) {

    DialobFormServiceApi dialobFormServiceApi = new DialobFormServiceApiImpl();
    ((DialobFormServiceApiImpl) dialobFormServiceApi).getApiClient().setApiKey("localhost-test:secret-api-key");
    dialobFormServiceApi.getFormUsingGET("inRuleTest", "LATEST", formAsyncResult -> {
      System.out.println(formAsyncResult.result());
    });

  }
}
