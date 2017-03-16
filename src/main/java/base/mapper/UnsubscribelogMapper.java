package base.mapper;

import base.model.Unsubscribelog;
import base.model.UnsubscribelogExample;
import base.model.UnsubscribelogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnsubscribelogMapper {
    int countByExample(UnsubscribelogExample example);

    int deleteByExample(UnsubscribelogExample example);

    int deleteByPrimaryKey(UnsubscribelogKey key);

    int insert(Unsubscribelog record);

    int insertSelective(Unsubscribelog record);

    List<Unsubscribelog> selectByExample(UnsubscribelogExample example);

    Unsubscribelog selectByPrimaryKey(UnsubscribelogKey key);

    int updateByExampleSelective(@Param("record") Unsubscribelog record, @Param("example") UnsubscribelogExample example);

    int updateByExample(@Param("record") Unsubscribelog record, @Param("example") UnsubscribelogExample example);

    int updateByPrimaryKeySelective(Unsubscribelog record);

    int updateByPrimaryKey(Unsubscribelog record);
}