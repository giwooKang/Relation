package relation.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.stereotype.Service;
import relation.domain.HotKeyword;
import relation.domain.Relation;
import relation.domain.RelationToJsonWrapper;
import relation.domain.daum.DaumImageResult;
import relation.domain.naver.NaverImageResult;
import relation.repository.RelationMapper;
import twitter4j.*;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by DK on 2016-12-06.
 */
@Service
public class RelationService {
    @Inject
    private DocumentParserService documentParserService;
    @Inject
    private NaverRelationAnalyzeService naverRelationAnalyzeService;
    @Inject
    private NaverService naverService;
    @Inject
    private DaumService daumService;
    @Inject
    private RelationMapper relationMapper;
    @Inject
    private TwitterService twitterService;

    public Relation findRelationByKeyword(String keyword) {
        try{
            List<RelationToJsonWrapper> relationList = relationMapper.findByKeyword(keyword);
            if(relationList.size() == 0) {
                HashMap<String, Integer> relation = getRelatedSearchesMap(keyword, false);

                // relation 분석 결과에 트위터 검색 결과 등장하는 단어 수 만큼 가중치 부여
                twitterService.accumulateTwitterSearchWeight(relation, keyword);

                Calendar cal = Calendar.getInstance();
                RelationToJsonWrapper wrapper = new RelationToJsonWrapper(new Relation(keyword, new Timestamp(cal.getTimeInMillis()), relation));
                relationMapper.insert(wrapper);

                return wrapper.toRelation();
            }else{
                return relationList.get(0).toRelation();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public HashSet<String> getCurrentList(){
        HashSet<String> rankSet = new HashSet<String>();

        List<String> naverKeywordList = new ArrayList<String>();
        List<String> daumKeywordList = new ArrayList<String>();

        naverKeywordList.addAll(documentParserService.getCurrentRankList(DocumentParserService.Site.Naver));
        daumKeywordList.addAll(documentParserService.getCurrentRankList(DocumentParserService.Site.Daum));

        rankSet.addAll(naverKeywordList);
        rankSet.addAll(daumKeywordList);

        return rankSet;
    }

    public List<HotKeyword> getCurrentRankList() {
        HashSet<String> rankSet = new HashSet<String>();

        List<String> naverKeywordList = new ArrayList<String>();
        List<String> daumKeywordList = new ArrayList<String>();

        naverKeywordList.addAll(documentParserService.getCurrentRankList(DocumentParserService.Site.Naver));
        daumKeywordList.addAll(documentParserService.getCurrentRankList(DocumentParserService.Site.Daum));

        rankSet.addAll(naverKeywordList);
        rankSet.addAll(daumKeywordList);

        Calendar cal = Calendar.getInstance();
        List<HotKeyword> hotKeywords = new ArrayList<HotKeyword>();

        for(String keyword : rankSet) {
            if(naverKeywordList.contains(keyword)) {
                NaverImageResult result = naverService.searchKeyword(keyword);
                String thumbnail;
                try {
                    thumbnail = result.getItems().get(0).getThumbnail();
                }catch (Exception e){
                    thumbnail = "";
                }

                hotKeywords.add(new HotKeyword(keyword, thumbnail, false, true, false, new Timestamp(cal.getTimeInMillis())));

            }else if(daumKeywordList.contains(keyword)) {
                DaumImageResult result = daumService.searchKeyword(keyword);
                String thumbnail;
                try {
                    thumbnail = result.getChannel().getItem().get(0).getThumbnail();
                }catch (Exception e){
                    thumbnail = "";
                }

                hotKeywords.add(new HotKeyword(keyword, thumbnail, false, false, true, new Timestamp(cal.getTimeInMillis())));
            }
        }

        return hotKeywords;
    }

    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v1).compareTo(v2);
            }

        });
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }

    public HashMap<String, Integer> getRelatedSearchesMap(String keyword, boolean hasDealy){
        return naverRelationAnalyzeService.getRelatedSearchesMap(keyword, 2, hasDealy);
    }
}
