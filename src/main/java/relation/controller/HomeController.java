package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import relation.domain.HotKeyword;
import relation.service.DaumService;
import relation.service.NaverService;
import relation.service.RelationUtil;
import relation.repository.HotKeywordMapper;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.*;


@Controller
@RequestMapping("/")
public class HomeController {
    @Inject
    NaverService naverService;
    @Inject
    DaumService daumService;
    @Inject
    RelationUtil relationUtil;

    @Inject
    HotKeywordMapper hotKeywordMapper;

    @RequestMapping
    public String home() {
        HashSet<String> nRankList= null;
        HashSet<String> dRankList = null;
        HashMap<String,Integer> aa= new HashMap<String,Integer>();
        HotKeyword hotKeyword = new HotKeyword();
        hotKeyword.setDatetime(new Timestamp(Calendar.getInstance().getTime().getTime()));
        hotKeyword.setDaum(true);
        hotKeyword.setGoogle(false);
        hotKeyword.setNaver(true);
        hotKeyword.setImage("image");
        hotKeyword.setKeyword("keyword");

        //hotKeywordMapper.insert(hotKeyword);
        for(HotKeyword h:hotKeywordMapper.findByKeyword("keyword")){
            System.out.println(h);
        }


/*        nRankList = naverParser.getCurrentRankList();
        dRankList= daumParser.getCurrentRankList();


        aa = naverParser.getRelatedSearchesMap("최순실",2);
        for(String e: aa.keySet()){
           // System.out.println(e +" : " + aa.get(e));
        }
        List<String> aaa = ParserUtil.sortByValue(aa);
        for(String e: aaa){
            System.out.println(e);
        }*/
        //naverParser.getRelatedSearches("정유라");
        //daumParser.getRelatedSearches("abc");
        return "index";
    }



}