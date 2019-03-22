import com.fasterxml.jackson.databind.ObjectMapper;
import io.dialob.api.client.DialobFormServiceApi;
import io.dialob.api.client.okhttp.ApiClient;
import io.dialob.api.form.model.Form;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Tester {
  public static void main(String[] args) {

    RestTemplate restTemplate = new RestTemplate();
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
      new MappingJackson2HttpMessageConverter();
    mappingJackson2HttpMessageConverter.setObjectMapper(new ObjectMapper());
    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
      Arrays.asList(
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_JSON_UTF8,
        MediaType.APPLICATION_OCTET_STREAM));
    restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

    ApiClient apiClient = new ApiClient(restTemplate);
    apiClient.setBasePath("https://demo.dialob.io/api");
    apiClient.setApiKey("localhost-test:secret-api-key");


    DialobFormServiceApi serviceApi = new DialobFormServiceApi(apiClient);

    Form form = serviceApi.getFormUsingGET("inRuleTest", null);
    System.out.println(form);
  }
}
