package base.serviceImpl;

import base.mapper.ApproveoldMapper;
import base.mapper.ManagerMapper;
import base.mapper.RawcourseMapper;
import base.model.*;
import base.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugi on 2017/3/21.
 */
@Service
public class ManagerServiceImpl implements ManagerService{

    @Resource
    ManagerMapper managerMapper;
    @Resource
    RawcourseMapper rawcourseMapper;
    @Resource
    ApproveoldMapper approveoldMapper;

    @Override
    public Manager getManagerByUsername(String username) throws Exception {
        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagernameEqualTo(username);
        List<Manager> managerList = managerMapper.selectByExample(managerExample);
        System.out.println("getManagerByUsername,size:"+managerList.size());
        return managerList.get(0);
    }

    @Override
    public List<Rawcourse> getRawCourse() throws Exception {
        RawcourseExample rawcourseExample = new RawcourseExample();
        RawcourseExample.Criteria criteria = rawcourseExample.createCriteria();
        criteria.andStateEqualTo(0);
        List<Rawcourse> rawcourseList = rawcourseMapper.selectByExample(rawcourseExample);
        return rawcourseList;
    }

    @Override
    public List<Approveold> getModifyCourse() throws Exception {
        ApproveoldExample approveoldExample = new ApproveoldExample();
        ApproveoldExample.Criteria criteria = approveoldExample.createCriteria();
        criteria.andStateEqualTo(0);
        List<Approveold> approveoldList = approveoldMapper.selectByExample(approveoldExample);

        return approveoldList;
    }
}
