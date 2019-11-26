import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <br>
 * <br>Darian
 **/
public class RestTempleteDemo {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        System.out.println(restTemplate.getForObject("http://localhost:8080/env",String.class));
    }
}
