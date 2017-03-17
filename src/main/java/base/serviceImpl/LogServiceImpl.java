package base.serviceImpl;

import base.mapper.*;
import base.model.*;
import base.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugi on 2017/3/16.
 */
@Service
public class LogServiceImpl implements LogService{

    @Resource
    TraineeMapper traineeMapper;
    @Resource
    DroplogMapper droplogMapper;
    @Resource
    ExchangelogMapper exchangelogMapper;
    @Resource
    RechargelogMapper rechargelogMapper;
    @Resource
    SubscribelogMapper subscribelogMapper;
    @Resource
    UnsubscribelogMapper unsubscribelogMapper;

    @Override
    public List<Droplog> getDroplogByID(int traineeid) throws Exception {
        DroplogExample droplogExample = new DroplogExample();
        DroplogExample.Criteria criteria1 = droplogExample.createCriteria();
        criteria1.andTraineeidEqualTo(traineeid);
        List<Droplog> droplogList = droplogMapper.selectByExample(droplogExample);

        return droplogList;
    }

    @Override
    public List<Exchangelog> getExchangelogByID(int traineeid) throws Exception {
          ExchangelogExample exchangelogExample = new ExchangelogExample();
        ExchangelogExample.Criteria criteria1 = exchangelogExample.createCriteria();
        criteria1.andTraineeidEqualTo(traineeid);
        List<Exchangelog> exchangelogList = exchangelogMapper.selectByExample(exchangelogExample);
        return exchangelogList;
    }

    @Override
    public List<Rechargelog> getRechargelogByID(int traineeid) throws Exception {
        RechargelogExample rechargelogExample = new RechargelogExample();
        RechargelogExample.Criteria criteria1 = rechargelogExample.createCriteria();
        criteria1.andTraineeidEqualTo(traineeid);
        List<Rechargelog> rechargelogList = rechargelogMapper.selectByExample(rechargelogExample);
        return rechargelogList;
    }

    @Override
    public List<Subscribelog> getSubscribelogByID(int traineeid) throws Exception {
        SubscribelogExample subscribelogExample = new SubscribelogExample();
        SubscribelogExample.Criteria criteria1 = subscribelogExample.createCriteria();
        criteria1.andTraineeidEqualTo(traineeid);
        List<Subscribelog> subscribelogList = subscribelogMapper.selectByExample(subscribelogExample);
        return subscribelogList;
    }

    @Override
    public List<Unsubscribelog> getUnsubscribelogByID(int traineeid) throws Exception {
        UnsubscribelogExample unsubscribelogExample = new UnsubscribelogExample();
        UnsubscribelogExample.Criteria criteria1 = unsubscribelogExample.createCriteria();
        criteria1.andTraineeidEqualTo(traineeid);
        List<Unsubscribelog> unsubscribelogList = unsubscribelogMapper.selectByExample(unsubscribelogExample);
        return unsubscribelogList;
    }
}