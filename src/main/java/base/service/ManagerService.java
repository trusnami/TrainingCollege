package base.service;

import base.model.Approveold;
import base.model.Manager;
import base.model.Rawcourse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yugi on 2017/3/21.
 */
@Service
public interface ManagerService {

    Manager getManagerByUsername(String username) throws Exception;

    List<Rawcourse> getRawCourse () throws Exception;

    List<Approveold> getModifyCourse() throws Exception;

}
