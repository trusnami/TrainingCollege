package base.mapper;

import base.model.Approveold;
import base.model.ApproveoldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApproveoldMapper {
    int countByExample(ApproveoldExample example);

    int deleteByExample(ApproveoldExample example);

    int deleteByPrimaryKey(Integer logid);

    int insert(Approveold record);

    int insertSelective(Approveold record);

    List<Approveold> selectByExample(ApproveoldExample example);

    Approveold selectByPrimaryKey(Integer logid);

    int updateByExampleSelective(@Param("record") Approveold record, @Param("example") ApproveoldExample example);

    int updateByExample(@Param("record") Approveold record, @Param("example") ApproveoldExample example);

    int updateByPrimaryKeySelective(Approveold record);

    int updateByPrimaryKey(Approveold record);
}