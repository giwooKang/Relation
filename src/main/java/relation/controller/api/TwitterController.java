package relation.controller.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import relation.domain.daum.DaumImageResult;
import relation.domain.naver.NaverImageResult;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by Cro on 2016-12-05.
 */

@Controller
@RequestMapping("/twitter")
public class TwitterController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String twitterSearch() {
        return "twitterSearch";
    }

    @RequestMapping
    public String twitterMain() {
        return "twitterSearch";
    }

    @RequestMapping("/result")
    public String TwitterResult(Model model, @RequestParam(name="keyword") String keyword) {
//        트위터
//        Twitter twitter = new TwitterFactory().getInstance();
//        try {
//            QueryResult result = twitter.search(new Query(keyword));
//            List<Status> tweets = result.getTweets();
//
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("tweets", tweets);
//        } catch (TwitterException te) {
//            // do nothing
//        }

//        네이버
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Naver-Client-Id", "3n_QVryXZYHZZNVxez2A");
//        headers.add("X-Naver-Client-Secret", "e5plstdc06");
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//        try{
//            ResponseEntity<NaverImageResult> naverImageResultResponseEntity = restTemplate.exchange("https://openapi.naver.com/v1/search/image.json?query="+keyword+"&sort=sim", HttpMethod.GET, entity, NaverImageResult.class);
//            NaverImageResult result = naverImageResultResponseEntity.getBody();
//
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("tweets", result.getItems());
//        }catch (RestClientException e){
//            e.printStackTrace();
//        }

        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<DaumImageResult> daumImageResultResponseEntity = restTemplate.getForEntity("https://apis.daum.net/search/image?apikey=43380223cdfbc19f8381059bff9954b3&output=json&q=" + keyword, DaumImageResult.class);
            DaumImageResult result = daumImageResultResponseEntity.getBody();

            model.addAttribute("keyword", keyword);
            model.addAttribute("tweets", result.getChannel().getItem());
        }catch (RestClientException e){
            e.printStackTrace();
        }

        return "twitterResult";
    }
}
