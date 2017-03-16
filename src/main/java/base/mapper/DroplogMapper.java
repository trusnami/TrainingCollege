package base.mapper;

import base.model.Droplog;
import base.model.DroplogExample;
import base.model.DroplogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DroplogMapper {
    int countByExample(DroplogExample example);

    int deleteByExample(DroplogExample example);

    int deleteByPrimaryKey(DroplogKey key);

    int insert(Droplog record);

    int insertSelective(Droplog record);

    List<Droplog> selectByExample(DroplogExample example);

    Droplog selectByPrimaryKey(DroplogKey key);

    int updateByExampleSelective(@Param("record") Droplog record, @Param("example") DroplogExample example);

    int updateByExample(@Param("record") Droplog record, @Param("example") DroplogExample example);

    int updateByPrimaryKeySelective(Droplog record);

    int updateByPrimaryKey(Droplog record);
}