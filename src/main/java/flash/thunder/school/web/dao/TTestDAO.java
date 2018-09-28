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

    public List<TTest> select (){
        String sql="SELECT * FROM t_test WHERE id=1;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TTest.class));
    }
}
