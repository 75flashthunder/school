package flash.thunder.school.web.service;

import flash.thunder.school.web.dao.WebDAO;
import flash.thunder.school.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/9/28.
 */
@Service
public class WebService {
    @Autowired
    private WebDAO webDAO;
    public boolean select(UserEntity user){
       return webDAO.select(user);
    }
}
