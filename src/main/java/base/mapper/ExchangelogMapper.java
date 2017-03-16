package base.mapper;

import base.model.Exchangelog;
import base.model.ExchangelogExample;
import base.model.ExchangelogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExchangelogMapper {
    int countByExample(ExchangelogExample example);

    int deleteByExample(ExchangelogExample example);

    int deleteByPrimaryKey(ExchangelogKey key);

    int insert(Exchangelog record);

    int insertSelective(Exchangelog record);

    List<Exchangelog> selectByExample(ExchangelogExample example);

    Exchangelog selectByPrimaryKey(ExchangelogKey key);

    int updateByExampleSelective(@Param("record") Exchangelog record, @Param("example") ExchangelogExample example);

    int updateByExample(@Param("record") Exchangelog record, @Param("example") ExchangelogExample example);

    int updateByPrimaryKeySelective(Exchangelog record);

    int updateByPrimaryKey(Exchangelog record);
}