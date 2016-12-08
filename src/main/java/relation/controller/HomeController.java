package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import relation.domain.Relation;
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
        Relation rel = null;
        if(relationToJsonWrapperList.size()==0) {
            rel = relationService.findRelationByKeyword(keyword);
        }else {
            rel = relationToJsonWrapperList.get(0).toRelation();
        }
        model.addAttribute("keyword",rel);
        HashMap<String,Integer> map = rel.getRelation();

        HashMap<String,Integer> ids = new HashMap<String, Integer>();

        int i=1;
        String json="";
        for (String s: map.keySet()){
            if(map.get(s) > 1) {
                String temp = "{data: { id: '" + i + "',name:'" + s + "',weight :"+(float)map.get(s)*100+"  }},";
                ids.put(s,i);
                json += temp;
                i++;
            }
        }
        int id = i+1;
        List<String> sortlist = RelationService.sortByValue(ids);

        for (String key:sortlist){
            for(int j=0;j<map.get(key);j++){
                String temp="{data: { id: '"+(id++)+"', source:'"+ids.get(key)+"' , target:'"+ids.get(sortlist.get(j))+"'}},";
                json+=temp;
            }
        }



        /*
        for(int j=1;j<i;j++){
            for(int k=j+1;k<i;k++){
                String temp="{data: { id: '"+(id++)+"', source:'"+j+"' , target:'"+k+"'}},";
                json+=temp;
            }

        }*/
        json=json.substring(0, json.length()-1);
        System.out.println(id);
        model.addAttribute("json",json);

        model.addAttribute("currentHot",relationService.getCurrentList().iterator());
        return "search";
    }
}