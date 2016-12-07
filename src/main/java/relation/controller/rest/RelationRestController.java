package relation.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relation.domain.Relation;
import relation.domain.RelationToJsonWrapper;
import relation.repository.RelationMapper;

import javax.inject.Inject;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cro on 2016-12-06.
 */

@RestController
@RequestMapping("/rest")
public class RelationRestController {

    @Inject
    private RelationMapper relationMapper;

    @RequestMapping(value = "/requestRelation", method = RequestMethod.GET, produces = "application/json")
    public Relation getRelation(@RequestParam(value="keyword", defaultValue="") String keyword){
        List<RelationToJsonWrapper> relationList = relationMapper.findByKeyword(keyword);
        if(relationList.size() == 0 || keyword.equals("")) {
            // db에 키워드 존재하지 않음, 새로 만들어 반환?
            HashMap<String, Integer> dummyKeywordMap = new HashMap<String, Integer>();

            dummyKeywordMap.put("박근혜", 1);
            dummyKeywordMap.put("박근혜 하야", 1);
            dummyKeywordMap.put("박근혜 국정농단", 1);
            dummyKeywordMap.put("박근혜 최순실 관계", 1);
            dummyKeywordMap.put("최순실", 1);
            dummyKeywordMap.put("더미데이터", 1);

            Calendar calendar = Calendar.getInstance();
            Relation relation = new Relation("박근혜", new java.sql.Timestamp(calendar.getTimeInMillis()), dummyKeywordMap);
            relationMapper.insert(new RelationToJsonWrapper(relation));

            return relation;
        }
        return relationList.get(0).toRelation();
    }

//    @RequestMapping(value = "/requestHotKeyword", method = RequestMethod.GET, produces = "application/json")
//    public Relation getRelation(@RequestParam(value="period", defaultValue="") String keyword){
//        List<RelationToJsonWrapper> relationList = relationMapper.findByKeyword(keyword);
//        if(relationList.size() == 0) {
//            // db에 키워드 존재하지 않음, 새로 만들어 반환?
//            HashMap<String, Integer> dummyKeywordMap = new HashMap<String, Integer>();
//
//            dummyKeywordMap.put("박근혜", 1);
//            dummyKeywordMap.put("박근혜 하야", 1);
//            dummyKeywordMap.put("박근혜 국정농단", 1);
//            dummyKeywordMap.put("박근혜 최순실 관계", 1);
//            dummyKeywordMap.put("최순실", 1);
//            dummyKeywordMap.put("더미데이터", 1);
//
//            Calendar calendar = Calendar.getInstance();
//            Relation relation = new Relation("박근혜", new java.sql.Timestamp(calendar.getTimeInMillis()), dummyKeywordMap);
//            relationMapper.insert(new RelationToJsonWrapper(relation));
//
//            return relation;
//        }
//        return relationList.get(0).toRelation();
//    }
}
