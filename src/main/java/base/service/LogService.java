package base.service;

import base.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yugi on 2017/3/16.
 */
@Service
public interface LogService {

    List<Droplog> getDroplogByID(int traineeid) throws Exception;

    List<Exchangelog> getExchangelogByID(int traineeid) throws Exception;

    List<Rechargelog> getRechargelogByID(int traineeid) throws Exception;

    List<Rechargelog> getAllRechargelog() throws Exception;

    List<Subscribelog> getSubscribelogByID(int traineeid) throws Exception;

    List<Unsubscribelog> getUnsubscribelogByID(int traineeid) throws Exception;

    List<Subscribelog> getSubscribelogByCourse(int courseid) throws Exception;

    List<Unsubscribelog> getUnsubscribelogByCourse(int courseid) throws Exception;

    List<Droplog> getDroplogByCourse(int courseid) throws Exception;

    List<Settlelog> getSettlelogByinstitutionid(int institutionid) throws Exception;
}
