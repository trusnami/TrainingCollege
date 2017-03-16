package base.service;

import base.model.Trainee;
import base.model.TraineeExample;
import org.springframework.stereotype.Service;


/**
 * Created by yugi on 2017/3/13.
 */
@Service
public interface TraineeService {

    Trainee getTraineeByUsername(String username) throws Exception;

    boolean addBalance(String username,String number) throws Exception;

    int exchange(String username,int money) throws  Exception;

}
