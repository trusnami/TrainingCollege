package base.mapper;

import base.model.TclassExample;
import base.model.TclassKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TclassMapper {
    int countByExample(TclassExample example);

    int deleteByExample(TclassExample example);

    int deleteByPrimaryKey(TclassKey key);

    int insert(TclassKey record);

    int insertSelective(TclassKey record);

    List<TclassKey> selectByExample(TclassExample example);

    int updateByExampleSelective(@Param("record") TclassKey record, @Param("example") TclassExample example);

    int updateByExample(@Param("record") TclassKey record, @Param("example") TclassExample example);
}