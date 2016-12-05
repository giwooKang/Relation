package relation.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

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

//        만약 twitter4j.properties 없이 authentication 수행하려면 아래 코드 사용
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//                .setOAuthConsumerKey("9lx3mOFnXRoawRCj3XCUBXcAS")
//                .setOAuthConsumerSecret("Igw6SNcU6uKxRXyNjg3eZIz1Bewhrx4eN17mi4xNoxF5Hv5Thp")
//                .setOAuthAccessToken("781292703317430272-euN6p1xndB4W1weSgvKSXdunnMudYm3")
//                .setOAuthAccessTokenSecret("7S039d5p9x8K22CjAOaVvaAfoCzG6fw8BZJtHHtdQgPq6");
//
//        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            QueryResult result = twitter.search(new Query(keyword));
            List<Status> tweets = result.getTweets();

            model.addAttribute("keyword", keyword);
            model.addAttribute("tweets", tweets);
        } catch (TwitterException te) {
            // do nothing
        }

        return "twitterResult";
    }
}
