package relation.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by DK on 2016-12-06.
 */
@Service
public class RelationUtil {
    @Inject
    NaverService naverService;
    @Inject
    DaumService daumService;

    public Document getDocument(String uri){
        Document doc=null;
        try{
            doc = Jsoup.connect(uri).header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36").get();
        }catch (Exception e){
            System.out.println("relation.service.ParserUtil : getDocument("+uri+") Error");
        }
        return doc;
    }

    public HashSet<String> getCurrentRankList(){
        HashSet<String> rankSet = new HashSet<String>();

        for(String word : daumService.getCurrentRankList()){
            rankSet.add(word);
        }
        for(String word: naverService.getCurrentRankList()){
            rankSet.add(word);
        }
        return rankSet;
    }

    public static List sortByValue(final Map map){
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list,new Comparator(){

            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v1).compareTo(v2);
            }

        });
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }


}
