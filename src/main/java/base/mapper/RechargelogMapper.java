package base.mapper;

import base.model.Rechargelog;
import base.model.RechargelogExample;
import base.model.RechargelogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargelogMapper {
    int countByExample(RechargelogExample example);

    int deleteByExample(RechargelogExample example);

    int deleteByPrimaryKey(RechargelogKey key);

    int insert(Rechargelog record);

    int insertSelective(Rechargelog record);

    List<Rechargelog> selectByExample(RechargelogExample example);

    Rechargelog selectByPrimaryKey(RechargelogKey key);

    int updateByExampleSelective(@Param("record") Rechargelog record, @Param("example") RechargelogExample example);

    int updateByExample(@Param("record") Rechargelog record, @Param("example") RechargelogExample example);

    int updateByPrimaryKeySelective(Rechargelog record);

    int updateByPrimaryKey(Rechargelog record);
}