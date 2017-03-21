package base.service;

import base.model.Institution;
import org.springframework.stereotype.Service;

/**
 * Created by yugi on 2017/3/15.
 */
@Service
public interface InstitutionService {
    Institution getInstitutionByUsername(String username) throws Exception;
    Institution getInstitutionByid(String id) throws Exception;
    boolean addBalance(int institutionid,double balance) throws Exception;
}
