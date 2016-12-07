package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import relation.domain.HotKeyword;
import relation.domain.Relation;
import relation.domain.RelationToJsonWrapper;
import relation.repository.RelationMapper;
import relation.service.DaumService;
import relation.service.NaverRelationAnalyzeService;
import relation.service.RelationService;
import relation.repository.HotKeywordMapper;

import javax.inject.Inject;
import java.sql.Timestamp;
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

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,@RequestParam(required=true) String keyword) {
        List<RelationToJsonWrapper> relationToJsonWrapperList = relationMapper.findByKeyword(keyword);

        if(relationToJsonWrapperList.size()==0) {

        }else {
            
        }


        relationMapper.findByKeyword("!23");

        return "search";
    }



}