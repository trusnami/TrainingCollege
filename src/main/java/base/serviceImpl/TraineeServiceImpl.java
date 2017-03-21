package base.serviceImpl;

import base.mapper.ExchangelogMapper;
import base.mapper.RechargelogMapper;
import base.mapper.TraineeMapper;
import base.model.Exchangelog;
import base.model.Rechargelog;
import base.model.Trainee;
import base.model.TraineeExample;
import base.service.TraineeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yugi on 2017/3/13.
 */
@Service
public class TraineeServiceImpl implements TraineeService{

    @Resource
    TraineeMapper traineeMapper;
    @Resource
    RechargelogMapper rechargelogMapper;
    @Resource
    ExchangelogMapper exchangelogMapper;

    @Override
    public Trainee getTraineeByUsername(String username) throws Exception {

        TraineeExample traineeExample = new TraineeExample();
        TraineeExample.Criteria criteria = traineeExample.createCriteria();

        criteria.andUsernameEqualTo(username);

        List<Trainee> traineeList = traineeMapper.selectByExample(traineeExample);

        return traineeList.get(0);
    }

    @Override
    public boolean addBalance(String username,String number) throws Exception {

        Trainee trainee = getTraineeByUsername(username);
        int amount = Integer.parseInt(number);
        double balance = trainee.getBalance();
        balance+=amount;
        trainee.setBalance(balance);
        Rechargelog  rechargelog= new Rechargelog();
        rechargelog.setAmount(amount);
        rechargelog.setTime(new Date());
        rechargelog.setTraineeid(trainee.getId());
        int result = traineeMapper.updateByPrimaryKey(trainee);
        int result1 = rechargelogMapper.insert(rechargelog);
        return false;
    }

    @Override
    public int exchange(String username, int money) throws Exception {

        Trainee trainee = getTraineeByUsername(username);
        double balance = trainee.getBalance();
        double point =trainee.getPoint();
        int level = trainee.getLevel();
        int deduction = 0;
        switch (level){
            case 0:
                return 1;
            case 1:
                deduction=money*30;
                if (point<deduction){
                    return 2;
                }
                break;
            case 2:
                deduction=money*25;
                if (point<deduction){
                    return 2;
                }
                break;
            case 3:
                deduction=money*20;
                if (point<deduction){
                    return 2;
                }
                break;
        }
        balance=balance+money;
        point=point-deduction;
        Exchangelog exchangelog = new Exchangelog();
        exchangelog.setTraineeid(trainee.getId());
        exchangelog.setTime(new Date());
        exchangelog.setAmount(money);
        exchangelog.setPoint(deduction);
        trainee.setBalance(balance);
        trainee.setPoint(point);
        traineeMapper.updateByPrimaryKey(trainee);
        exchangelogMapper.insert(exchangelog);
        return 0;
    }

    @Override
    public List<Trainee> getAlltrainee() throws Exception {
        TraineeExample traineeExample = new TraineeExample();
        TraineeExample.Criteria criteria = traineeExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(0);
        List<Trainee> traineeList = traineeMapper.selectByExample(traineeExample);

        return traineeList;
    }


}
