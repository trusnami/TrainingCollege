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

    List<Subscribelog> getSubscribelogByID(int traineeid) throws Exception;

    List<Unsubscribelog> getUnsubscribelogByID(int traineeid) throws Exception;

}