package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import relation.parser.DaumParser;
import relation.parser.NaverParser;
import relation.parser.ParserUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {
    @Inject
    NaverParser naverParser;
    @Inject
    DaumParser daumParser;
    @Inject
    ParserUtil parserUtil;


    @RequestMapping
    public String home() {
        HashSet<String> nRankList= null;
        HashSet<String> dRankList = null;
        HashMap<String,Integer> aa= new HashMap<String,Integer>();
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