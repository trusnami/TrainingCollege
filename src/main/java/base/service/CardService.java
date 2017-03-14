package base.service;

import org.springframework.stereotype.Service;
import base.model.Card;
import java.util.List;
/**
 * Created by yugi on 2017/3/13.
 */
@Service
public interface CardService {

    boolean addNewCard(int traineeid,String phonenumber,String cardnumber) throws Exception;

    List<Card> getCardByTraineeId(int id) throws Exception;

    boolean unbind (String cardnumber) throws Exception;

}
