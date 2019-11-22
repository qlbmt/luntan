package life.majiang.luntan.controller;

import life.majiang.luntan.mapper.UserMapper;
import life.majiang.luntan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2019/8/26.
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="/index")
    public String hello(@RequestParam(name = "name",required=false) String name, Model model, HttpServletRequest request){
        model.addAttribute("name",name);
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName() == "token"){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("token",token);
                }
                break;
            }
        }
        return "index";
    }
}
