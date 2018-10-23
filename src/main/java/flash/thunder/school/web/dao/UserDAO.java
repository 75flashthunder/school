package flash.thunder.school.web.dao;

import flash.thunder.school.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2018/9/28.
 */
@Component
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert (UserEntity user){
//        String sql="insert into t_bond_portfolio_auth_mapping (auth_type, create_time, source_id, source_type, tree_order, user_id) values (?,?,?,?,?,?)";
//        //  String formatSql = String.format(sql.toString(),authMapping.getAuthType(),authMapping.getCreateTime(),authMapping.getSourceId(),authMapping.getSourceType(),authMapping.getTreeOrder(),authMapping.getUserId());
//
//        return jdbcTemplate.update(sql, (x)->{
//            x.setInt(1,authMapping.getAuthType());
//            x.setTimestamp(2,new java.sql.Timestamp(authMapping.getCreateTime().getTime()));
//            x.setLong(3,authMapping.getSourceId());
//            x.setInt(4,authMapping.getSourceType());
//            x.setInt(5,authMapping.getTreeOrder());
//            x.setInt(6,authMapping.getUserId());});
        return true;
    }
}
