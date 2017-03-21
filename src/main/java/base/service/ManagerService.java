package base.service;

import base.model.*;
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

    List<Course> getScoredCourse() throws Exception;

    boolean newSettltlog(int institutionid ,double money,int courseid) throws Exception;

    List<Settlelog> getAllSettlelog() throws Exception;
}
