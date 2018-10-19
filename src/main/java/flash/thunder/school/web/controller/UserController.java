package flash.thunder.school.web.controller;

import flash.thunder.school.web.entity.UserEntity;
import flash.thunder.school.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/10/19.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = "application/json")
    public String register(@RequestParam UserEntity user){
        return userService.insert(user)? "index":"";
    }
}
