package life.majiang.luntan.controller;

import life.majiang.luntan.mapper.QuestionMapper;
import life.majiang.luntan.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2019/11/21.
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @RequestMapping("/publish")
    public String publish(@RequestParam(value = "name",required = false) String name){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            Model model, HttpServletRequest request
            ){
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);

        model.addAttribute("error","错误");
        questionMapper.create(question);
        return "publish";
    }
}
