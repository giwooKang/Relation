package relation.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by DK on 2016-12-05.
 */

@Service
public class NaverRelationAnalyzeService {
    @Inject
    DocumentParserService documentParserService;
    @Inject
    RelationService relationService;

    public HashSet<String> getRelatedSearches(String word) {
        Document doc = documentParserService.getDocument("https://search.naver.com/search.naver?query=" + word);
        Elements rankElement = doc.select("#nx_related_keywords .lst_relate li");

        HashSet<String> relSet = new HashSet<String>();
        for (Element e : rankElement) {
            relSet.add(e.text());
        }

        return relSet;
    }

    public HashMap<String, Integer> getRelatedSearchesMap(String word, int depth, boolean hasDealy) {
        HashMap<String, Integer> relMap = new HashMap<String, Integer>();
        HashMap<String, Integer> tempMap;
        HashSet<String> resultSet = getRelatedSearches(word);

        for (String relWord : resultSet) {
            if (relMap.containsKey(relWord)) {
                relMap.put(relWord, relMap.get(relWord) + 1);
            } else {
                relMap.put(relWord, 1);
            }
        }

        if (depth > 1) {
            for (String relWord : resultSet) {
                if(hasDealy) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        // do nothing
                    }
                }

                tempMap = getRelatedSearchesMap(relWord, depth - 1, hasDealy);
                for (String result : tempMap.keySet()) {
                    if (relMap.containsKey(result)) {
                        relMap.put(result, relMap.get(result) + tempMap.get(result));
                    } else {
                        relMap.put(result, 1);
                    }
                }
            }
        }
        return relMap;
    }
}
