package base.mapper;

import base.model.Settlelog;
import base.model.SettlelogExample;
import base.model.SettlelogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlelogMapper {
    int countByExample(SettlelogExample example);

    int deleteByExample(SettlelogExample example);

    int deleteByPrimaryKey(SettlelogKey key);

    int insert(Settlelog record);

    int insertSelective(Settlelog record);

    List<Settlelog> selectByExample(SettlelogExample example);

    Settlelog selectByPrimaryKey(SettlelogKey key);

    int updateByExampleSelective(@Param("record") Settlelog record, @Param("example") SettlelogExample example);

    int updateByExample(@Param("record") Settlelog record, @Param("example") SettlelogExample example);

    int updateByPrimaryKeySelective(Settlelog record);

    int updateByPrimaryKey(Settlelog record);
}