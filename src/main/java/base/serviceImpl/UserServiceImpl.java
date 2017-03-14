package base.serviceImpl;

import base.helper.ID;
import base.mapper.UserMapper;
import base.model.User;
import org.springframework.stereotype.Service;
import base.service.UserService;

import javax.annotation.Resource;

/**
 * Created by yugi on 2017/3/12.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int login(String userName, String password) throws Exception {

        User user = userMapper.selectByPrimaryKey(userName);

        if (user == null){
            return  4;

        }

        if (!user.getPassword().equals(password)){
            return 3;
        }

        int identity = user.getIdentity();

        return identity;

        //return null;
    }

}
