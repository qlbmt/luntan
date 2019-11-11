package life.majiang.luntan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by admin on 2019/8/26.
 */
@Controller
public class IndexController {

    @GetMapping(value="/index")
    public String hello(@RequestParam(name = "name",required=false) String name, Model model){
        model.addAttribute("name",name);
        return "index";
    }
}
