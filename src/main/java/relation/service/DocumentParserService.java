package relation.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Cro on 2016-12-07.
 */

@Service
public class DocumentParserService {
    public enum Site{
        Naver,
        Daum
    }

    public Document getDocument(String uri) {
        Document doc = null;
        try {
            doc = Jsoup.connect(uri).header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36").get();
        } catch (Exception e) {
            System.out.println("relation.service.ParserUtil : getDocument(" + uri + ") Error");
        }
        return doc;
    }

    public HashSet<String> getCurrentRankList(Site siteType) {
        Document doc;
        Elements rankElement;
        HashSet<String> rankSet = new HashSet<String>();

        switch (siteType) {
            case Naver:{
                doc = getDocument("http://www.naver.com");
                rankElement = doc.select("#ranklist a");

                for(Element e : rankElement){
                    rankSet.add(e.text().split("상승")[0]);
                }
            } break;
            case Daum: {
                doc = getDocument("http://www.daum.net");
                rankElement = doc.select("#realTimeSearchWord .txt_issue a.ellipsis_g");

                for (Element e : rankElement) {
                    rankSet.add(e.text());
                }
            } break;
            default:
                return null;
        }

        return rankSet;
    }
}
