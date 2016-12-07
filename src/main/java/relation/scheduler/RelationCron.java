package relation.scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import relation.domain.HotKeyword;
import relation.domain.Relation;
import relation.domain.RelationToJsonWrapper;
import relation.repository.HotKeywordMapper;
import relation.repository.RelationMapper;
import relation.service.RelationService;
import relation.service.TwitterService;
import twitter4j.*;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Cro on 2016-12-07.
 */

@Component
public class RelationCron {
    @Inject
    private RelationService relationService;
    @Inject
    private HotKeywordMapper hotKeywordMapper;
    @Inject
    private RelationMapper relationMapper;
    @Inject
    private TwitterService twitterService;

    @Async
    @Scheduled(fixedRate = 3600000)
    public void CropKeywordAndAnalyzeRelation() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println("Asynchronous method : CropKeywordAndAnalyzeRelation is started at " +  dateFormat.format(cal.getTime()));

        List<HotKeyword> hotKeywordAtNow = relationService.getCurrentRankList();

        // Step 1 : HotKeyword DB에 추가
        for(HotKeyword item : hotKeywordAtNow) {
            hotKeywordMapper.insert(item);
        }

        // Step 2 : relation 분석 후 DB에 추가
        for(HotKeyword item : hotKeywordAtNow) {
            HashMap<String, Integer> relation = relationService.getRelatedSearchesMap(item.getKeyword(), true);

            twitterService.accumulateTwitterSearchWeight(relation, item.getKeyword());

            List<RelationToJsonWrapper> relationToJsonWrapperList = relationMapper.findByKeyword(item.getKeyword());
            if(relationToJsonWrapperList.size()==0) {
                relationMapper.insert(new RelationToJsonWrapper(new Relation(item.getKeyword(), new Timestamp(cal.getTimeInMillis()), relation)));
            }else {
                relationMapper.update(new RelationToJsonWrapper(new Relation(relationToJsonWrapperList.get(0).getId(), item.getKeyword(), new Timestamp(cal.getTimeInMillis()), relation)));
            }
        }

        cal = Calendar.getInstance();
        System.out.println("Asynchronous method : CropKeywordAndAnalyzeRelation is ended at " +  dateFormat.format(cal.getTime()));
    }
}
