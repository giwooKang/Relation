package relation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import relation.domain.daum.DaumImageResult;

/**
 * Created by Cro on 2016-12-07.
 */

@Service
public class DaumService {
    public DaumImageResult searchKeyword(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<DaumImageResult> daumImageResultResponseEntity = restTemplate.getForEntity("https://apis.daum.net/search/image?apikey=43380223cdfbc19f8381059bff9954b3&output=json&q=" + keyword, DaumImageResult.class);
            DaumImageResult result = daumImageResultResponseEntity.getBody();
            return result;
        }catch (RestClientException e){
            e.printStackTrace();
        }

        return null;
    }
}
