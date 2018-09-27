package flash.thunder.school.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/8/7.
 */
@Controller
public class WebController {
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/house", method = RequestMethod.POST, produces = "application/json")
    public String mainPage(){
        return "house";
    }
}
