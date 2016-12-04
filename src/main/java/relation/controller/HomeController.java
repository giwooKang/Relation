package relation.controller;

/**
 * Created by DK on 2016-12-05.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${env.text}")
    private String env;

    @ModelAttribute("name")
    private String getName() {
        return "IamHomeControllerModelAttribute";
    }

    @RequestMapping
    public String home() {
        System.out.println(env);
        return "index";
    }



}