package flash.thunder.school.web.dao;

import flash.thunder.school.web.entity.DepartmentEntity;
import flash.thunder.school.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Administrator on 2018/9/28.
 */
@Component
public class WebDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean select (UserEntity user){
        String sql="SELECT * FROM t_ssyy_user WHERE user_name = '%1$s' AND password = '%2$s';";
        String formatsql=String.format(sql,user.getName(),user.getPassword());
        List<DepartmentEntity> t=jdbcTemplate.query(formatsql,new BeanPropertyRowMapper<>(DepartmentEntity.class));
        return t.size()>0? true:false;
    }

    public boolean selectDepartment (UserEntity user){
        String sql="SELECT * FROM t_ssyy_user WHERE user_name = '%1$s' AND password = '%2$s';";
        String formatsql=String.format(sql,user.getName(),user.getPassword());
        List<DepartmentEntity> t=jdbcTemplate.query(formatsql,new BeanPropertyRowMapper<>(DepartmentEntity.class));
        return t.size()>0? true:false;
    }
}
