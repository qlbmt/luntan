package life.majiang.luntan.controller;

import life.majiang.luntan.dto.AccessTokenDTO;
import life.majiang.luntan.dto.GithubUser;
import life.majiang.luntan.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * Created by admin on 2019/11/14.
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state , Model model) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("666cd028de094aca1efa");
        accessTokenDTO.setClient_secret("a097951bb5d2a0b6059501e9acaa4c4674d1226e");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);

        String accessToken =  githubProvider.getAccessToken(accessTokenDTO);
        System.out.println("access_token"+accessToken);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.toString());
        System.out.println(user.getName());
        model.addAttribute("name",user.getName());
        return "index";
    }
}
