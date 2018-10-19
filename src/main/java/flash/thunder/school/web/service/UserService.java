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
    public boolean insert(UserEntity user){
       return userDAO.insert(user);
    }
}
