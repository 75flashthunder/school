package flash.thunder.school.web.dao;

import flash.thunder.school.web.entity.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Administrator on 2018/9/28.
 */
@Component
public class TTestDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean select (TTest tTest){
        String sql="SELECT * FROM t_test WHERE name = '%1$s' AND password = '%2$s';";
        String formatsql=String.format(sql,tTest.getName(),tTest.getPassword());
        List<TTest> t=jdbcTemplate.query(formatsql,new BeanPropertyRowMapper<>(TTest.class));
        return t.size()>0? true:false;
    }
}
