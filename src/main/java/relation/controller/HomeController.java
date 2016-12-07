package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import relation.domain.HotKeyword;
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

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("hotkeywords",hotKeywordMapper.getDictinctRecentlyKeyword(10));

        return "index";
    }



}