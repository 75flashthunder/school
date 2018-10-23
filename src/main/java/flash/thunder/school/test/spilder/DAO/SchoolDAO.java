package flash.thunder.school.test.spilder.DAO;

import flash.thunder.school.test.spilder.Entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2018/10/23.
 */
@Component
public class SchoolDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert (School school){
        String sql = "INSERT INTO t_ssyy_school (211_flag,official_network,membership,brief,province,charge,ranking,schoolnature,old_name,level,autonomyrs,firsyrate,school_name,school_property,school_type,985_flag)"+
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, (x)->{
//            x.setInt(1,school.getSchoolId());
            x.setInt(1,school.getFlag211());
            x.setString(2,school.getOfficialNetwork());
            x.setString(3,school.getMembership());
            x.setString(4,school.getBrief());
            x.setString(5,school.getProvince());
            x.setString(6,school.getCharge());
            x.setInt(7,school.getRanking());
            x.setString(8,school.getSchoolNature());
            x.setString(9,school.getOldName());
            x.setString(10,school.getLevel());
            x.setInt(11,school.getAutonomyrs());
            x.setString(12,school.getFirsyrate());
            x.setString(13,school.getSchoolName());
            x.setString(14,school.getSchoolProperty());
            x.setString(15,school.getSchoolType());
            x.setDouble(16,school.getFlag985());
        });
    }
}
