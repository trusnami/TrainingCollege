package base.serviceImpl;

import base.mapper.CardMapper;
import base.model.Card;
import base.model.CardExample;
import base.service.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugi on 2017/3/13.
 */
@Service
public class CardServiceImpl implements CardService{

    @Resource
    CardMapper cardMapper;


    @Override
    public boolean addNewCard(int traineeid,String phonenumber,String cardnumber) throws Exception {

        Card card = new Card();
        card.setTraineeid(traineeid);
        card.setPhonenumber(phonenumber);
        card.setCardnumber(cardnumber);

        int result = cardMapper.insert(card);
        System.out.print(result+"\n");

        return false;
    }

    @Override
    public List<Card> getCardByTraineeId(int id) throws Exception {

        CardExample cardExample = new CardExample();
        CardExample.Criteria criteria= cardExample.createCriteria();

        criteria.andTraineeidEqualTo(id);

        List<Card> cardList = cardMapper.selectByExample(cardExample);

        return cardList;
    }

    @Override
    public boolean unbind(String cardnumber) throws Exception {

        int result = cardMapper.deleteByPrimaryKey(cardnumber);

        return false;
    }
}
