package base.service;

import org.springframework.stereotype.Service;

/**
 * Created by yugi on 2017/3/12.
 */
@Service
public interface UserService {
    int login(String userName, String password) throws Exception;

    int addNewUser(String userName, String password,int type) throws Exception;
}
