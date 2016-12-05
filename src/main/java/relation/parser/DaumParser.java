package relation.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashSet;

/**
 * Created by DK on 2016-12-05.
 */
@Service
public class DaumParser {
    @Inject
    ParserUtil parserUtil;
    public HashSet<String> getCurrentRankList(){

        Document doc = parserUtil.getDocument("http://www.daum.net");
        Elements rankElement = doc.select("#realTimeSearchWord .txt_issue a.ellipsis_g");

        HashSet<String> rankSet = new HashSet<String>();
        for(Element e : rankElement){
            rankSet.add(e.text());
        }
        return rankSet;
    }

    public  HashSet<String> getRelatedSearches(String word){
        Document doc = parserUtil.getDocument("http://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q="+word);
        Elements rankElement = doc.select("#netizen_lists_top a");

        HashSet<String> rankSet = new HashSet<String>();
        System.out.println("getRelatedSearches");
        System.out.println(doc.toString());
        for(Element e : rankElement){
            rankSet.add(e.text());
            System.out.println(e.text());

        }

        return rankSet;
    }


    public void test(){
        Document doc = parserUtil.getDocument("http://www.daum.net");
        Elements rankElement = doc.select("#realTimeSearchWord .txt_issue a[href]");

        HashSet<String> rankSet = new HashSet<String>();
        for(Element e : rankElement){
            System.out.println(parserUtil.getDocument(e.attr("href")).toString());
        }
    }

}
