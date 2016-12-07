package relation.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import relation.domain.naver.NaverImageResult;

/**
 * Created by Cro on 2016-12-07.
 */

@Service
public class NaverService {

    public NaverImageResult searchKeyword(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "3n_QVryXZYHZZNVxez2A");
        headers.add("X-Naver-Client-Secret", "e5plstdc06");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        try{
            ResponseEntity<NaverImageResult> naverImageResultResponseEntity = restTemplate.exchange("https://openapi.naver.com/v1/search/image.json?query="+keyword+"&sort=sim", HttpMethod.GET, entity, NaverImageResult.class);
            NaverImageResult result = naverImageResultResponseEntity.getBody();
            return result;
        }catch (RestClientException e){
            e.printStackTrace();
        }

        return null;
    }
}
