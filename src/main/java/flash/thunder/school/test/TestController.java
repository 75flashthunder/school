package flash.thunder.school.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/8/7.
 */
@Controller
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET, produces = "application/json")
    public String helloWorld(){
        return "helloWorld";
    }
}
