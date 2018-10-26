package flash.thunder.school.web.controller;

import flash.thunder.school.web.entity.UserEntity;
import flash.thunder.school.web.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/8/7.
 */
@Controller
public class WebController {
    @Autowired
    private WebService webService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = "application/json")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/house", method = RequestMethod.POST, produces = "application/json")
    public String house(){
        return "house";
    }

    @RequestMapping(value = "/login/check", method = RequestMethod.POST, produces = "application/json")
    public String mysqltest(@RequestParam String name, @RequestParam String password){
        UserEntity user=new UserEntity();
        user.setName(name);
        user.setPassword(password);
        return webService.select(user)? "index":"";
    }
}
