package flash.thunder.school.web.controller;

import flash.thunder.school.web.entity.UserEntity;
import flash.thunder.school.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/10/19.
 */
@Api(description = "用户操作")
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册用户")
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public String register(@RequestBody UserEntity user){
        return userService.insert(user)>0? "index":"";
    }
}
