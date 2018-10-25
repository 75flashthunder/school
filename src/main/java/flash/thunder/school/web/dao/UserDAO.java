package flash.thunder.school.web.dao;

import flash.thunder.school.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Administrator on 2018/9/28.
 */
@Component
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert (UserEntity user){
        String sql="insert into t_ssyy_user (user_name, password,email,school_id,department_id,major_id,local,create_time, update_time, update_user_id, delete_flag, gender,graduate_date,company_name,qq) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, (x)->{
            x.setString(1,user.getName());
            x.setString(2,user.getPassword());
            x.setString(3,user.getEmail());
            x.setInt(4,user.getSchoolId());
            x.setInt(5,user.getDepartmentId());
            x.setInt(6,user.getMajorId());
            x.setString(7,user.getLocal());
            x.setTimestamp(8,new java.sql.Timestamp(new Date().getTime()));
            x.setTimestamp(9,new java.sql.Timestamp(new Date().getTime()));
            x.setLong(10,user.getUpdateUserId());
            x.setInt(11,user.getIsDelete());
            x.setInt(12,user.getGender());
            x.setString(13,user.getGraduateDate());
            x.setString(14,user.getCompanyName());
            x.setLong(15,user.getQq());
        });
    }
}
