package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import relation.domain.RelationToJsonWrapper;
import relation.repository.RelationMapper;
import relation.service.DaumService;
import relation.service.NaverRelationAnalyzeService;
import relation.service.RelationService;
import relation.repository.HotKeywordMapper;

import javax.inject.Inject;
import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {
    @Inject
    NaverRelationAnalyzeService naverRelationAnalyzeService;
    @Inject
    DaumService daumService;
    @Inject
    RelationService relationService;
    @Inject
    HotKeywordMapper hotKeywordMapper;
    @Inject
    RelationMapper relationMapper;

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("hotkeywords",hotKeywordMapper.getDictinctRecentlyKeyword(30));
        model.addAttribute("currentHot",relationService.getCurrentList().iterator());


        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,@RequestParam(required=true) String keyword) {
        List<RelationToJsonWrapper> relationToJsonWrapperList = relationMapper.findByKeyword(keyword);

        if(relationToJsonWrapperList.size()==0) {

        }else {

        }
        model.addAttribute("keyword",relationToJsonWrapperList.get(0).toRelation());
        HashMap<String,Integer> map = relationToJsonWrapperList.get(0).toRelation().getRelation();

        int i=1;
        String json="";
        for (String s: map.keySet()){
            if(map.get(s) > 1) {
                String temp = "{data: { id: '" + i + "',name:'" + s + "',weight :"+(float)map.get(s)*100+"  }},";
                json += temp;
                i++;
            }
        }
        int id = i+1;
        for(int j=1;j<i;j++){
            for(int k=j+1;k<i;k++){
                String temp="{data: { id: '"+(id++)+"', source:'"+j+"' , target:'"+k+"'}},";
                json+=temp;
            }

        }
        json=json.substring(0, json.length()-1);
        System.out.println(id);
        model.addAttribute("json",json);
        return "search";
    }



}