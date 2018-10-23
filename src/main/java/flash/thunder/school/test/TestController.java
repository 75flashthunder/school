package flash.thunder.school.test;

import flash.thunder.school.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/8/7.
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String helloWorld(){
        return "hello";
    }

    @RequestMapping(value = "/spider", method = RequestMethod.GET, produces = "application/json")
    public void spider(){
         testService.spider();
    }
}
