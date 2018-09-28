package flash.thunder.school.web.service;

import flash.thunder.school.web.dao.TTestDAO;
import flash.thunder.school.web.entity.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */
@Service
public class MysqlTestService {
    @Autowired
    private TTestDAO tTestDAO;
    public List<TTest> select(){
       return tTestDAO.select();
    }
}
