package flash.thunder.school.web.service;

import flash.thunder.school.web.dao.UserDAO;
import flash.thunder.school.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/9/28.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public int insert(UserEntity user){
        user.setSchoolId(117);
        user.setDepartmentId(0);
        user.setMajorId(0);
        user.setUpdateUserId(0L);
        user.setIsDelete((short) 0);
        return userDAO.insert(user);
    }
}
