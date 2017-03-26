package base.serviceImpl;

import base.mapper.InstitutionMapper;
import base.mapper.TraineeMapper;
import base.mapper.UserMapper;
import base.model.Institution;
import base.model.Trainee;
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
    @Resource
    TraineeMapper traineeMapper;
    @Resource
    InstitutionMapper institutionMapper;

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

    @Override
    public int addNewUser(String userName, String password, int type) throws Exception {
        User user = new User();
        user.setIdentity(type);
        user.setPassword(password);
        user.setUsername(userName);
        int result = userMapper.insert(user);

        switch (type){
            case 1:
                Trainee trainee = new Trainee();
                trainee.setUsername(userName);
                trainee.setPassword(password);
                int result1 = traineeMapper.insertSelective(trainee);
                break;
            case 2:
                Institution institution = new Institution();
                institution.setUsername(userName);
                institution.setPassword(password);
                int result2 = institutionMapper.insertSelective(institution);
                break;
        }

        return 0;
    }

}
