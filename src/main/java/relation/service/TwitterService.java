package relation.service;

import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Cro on 2016-12-08.
 */
@Service
public class TwitterService {
    public void accumulateTwitterSearchWeight(HashMap<String, Integer> map, String keyword) {
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            QueryResult result = twitter.search(new Query(keyword));
            List<Status> tweets = result.getTweets();

            String allTweets = "";
            for(Status status : tweets) {
                allTweets += status.getText() + " ";
            }

            for(String key : map.keySet()) {
                String[] tokenize = allTweets.split(key);
                map.put(key, map.get(key) + tokenize.length - 1);
            }
        } catch (TwitterException te) {
            // do nothing
        }
    }
}
