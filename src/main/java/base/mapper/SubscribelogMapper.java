package base.mapper;

import base.model.Subscribelog;
import base.model.SubscribelogExample;
import base.model.SubscribelogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubscribelogMapper {
    int countByExample(SubscribelogExample example);

    int deleteByExample(SubscribelogExample example);

    int deleteByPrimaryKey(SubscribelogKey key);

    int insert(Subscribelog record);

    int insertSelective(Subscribelog record);

    List<Subscribelog> selectByExample(SubscribelogExample example);

    Subscribelog selectByPrimaryKey(SubscribelogKey key);

    int updateByExampleSelective(@Param("record") Subscribelog record, @Param("example") SubscribelogExample example);

    int updateByExample(@Param("record") Subscribelog record, @Param("example") SubscribelogExample example);

    int updateByPrimaryKeySelective(Subscribelog record);

    int updateByPrimaryKey(Subscribelog record);
}