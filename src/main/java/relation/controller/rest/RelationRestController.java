package relation.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import relation.domain.HotKeyword;
import relation.domain.Relation;
import relation.domain.RelationToJsonWrapper;
import relation.repository.HotKeywordMapper;
import relation.repository.RelationMapper;
import relation.service.RelationService;

import javax.inject.Inject;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Inject
    private RelationService relationService;
    @Inject
    private HotKeywordMapper hotKeywordMapper;

    @RequestMapping(value = "/requestRelation", method = RequestMethod.GET, produces = "application/json")
    public Relation getRelation(@RequestParam(value="keyword", defaultValue="") String keyword){
        if(keyword.equals("")) {
            return null;
        }
        List<RelationToJsonWrapper> relationList = relationMapper.findByKeyword(keyword);
        if(relationList.size() == 0) {
            Relation relation = relationService.findRelationByKeyword(keyword);
            return relation;
        }
        return relationList.get(0).toRelation();
    }

    @RequestMapping(value = "/requestHotKeyword", method = RequestMethod.GET, produces = "application/json")
    public List<HotKeyword> getHotKeywords(@RequestParam(value="startDate", defaultValue="_") String startDate, @RequestParam(value="endDate", defaultValue="_") String endDate, @RequestParam(value="count", defaultValue="10") String count, @RequestParam(value="distinct", defaultValue = "true") String isDistinct) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Timestamp start;
        Timestamp end;
        boolean distinct = true;
        int count_num;

        if(!isValidFormat(format, startDate)){
            startDate = format.format(cal.getTime());
        }
        if(!isValidFormat(format, endDate)) {
            cal.add(Calendar.DATE, 1);
            endDate = format.format(cal.getTime());
        }

        try{
            start = new Timestamp(format.parse(startDate).getTime());
            end = new Timestamp(format.parse(endDate).getTime());
            if(isDistinct.equals("false")){
                distinct = false;
            }
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
        try{
            count_num = Integer.parseInt(count);
        }catch (Exception e){
            count_num = 10;
        }

        List<HotKeyword> keywords;
        if(distinct) {
            keywords = hotKeywordMapper.getDistinctByDatetime(start, end, count_num);
        }else {
            keywords = hotKeywordMapper.getByDatetime(start, end, count_num);
        }
        return keywords;
    }

    private boolean isValidFormat(SimpleDateFormat format, String value) {
        Date date = null;
        try {
            date = format.parse(value);
            if (!value.equals(format.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
