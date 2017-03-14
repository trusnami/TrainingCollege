package base.serviceImpl;

import base.mapper.TraineeMapper;
import base.model.Trainee;
import base.model.TraineeExample;
import base.service.TraineeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugi on 2017/3/13.
 */
@Service
public class TraineeServiceImpl implements TraineeService{

    @Resource
    TraineeMapper traineeMapper;

    @Override
    public Trainee getTraineeByUsername(String username) throws Exception {

        TraineeExample traineeExample = new TraineeExample();
        TraineeExample.Criteria criteria = traineeExample.createCriteria();

        criteria.andUsernameEqualTo(username);

        List<Trainee> traineeList = traineeMapper.selectByExample(traineeExample);

        return traineeList.get(0);
    }

    @Override
    public boolean addBalance(Trainee trainee) throws Exception {

        int result = traineeMapper.updateByPrimaryKey(trainee);

        return false;
    }

    @Override
    public int exchange(String username, int money) throws Exception {

        Trainee trainee = getTraineeByUsername(username);
        double balance = trainee.getBalance();
        double point =trainee.getPoint();
        int level = trainee.getLevel();

        switch (level){
            case 0:
                return 1;
            case 1:
                if (point<money*30){
                    return 2;
                }
                balance=balance+money;
                point=point-money*30;
                trainee.setBalance(balance);
                trainee.setPoint(point);
                break;
            case 2:
                if (point<money*30){
                    return 2;
                }
                balance=balance+money;
                point=point-money*25;
                trainee.setBalance(balance);
                trainee.setPoint(point);
                break;
            case 3:
                if (point<money*30){
                    return 2;
                }
                balance=balance+money;
                point=point-money*20;
                trainee.setBalance(balance);
                trainee.setPoint(point);
                break;
        }

        traineeMapper.updateByPrimaryKey(trainee);
        return 0;
    }


}
