package base.serviceImpl;

import base.mapper.InstitutionMapper;
import base.model.Institution;
import base.model.InstitutionExample;
import base.service.InstitutionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugi on 2017/3/15.
 */
@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Resource
    InstitutionMapper institutionMapper;

    @Override
    public Institution getInstitutionByUsername(String username) throws Exception {
        InstitutionExample institutionExample = new InstitutionExample();
        InstitutionExample.Criteria criteria = institutionExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Institution> institutionList = institutionMapper.selectByExample(institutionExample);

        return institutionList.get(0);
    }
}
