package base.mapper;

import base.model.TcourseExample;
import base.model.TcourseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TcourseMapper {
    int countByExample(TcourseExample example);

    int deleteByExample(TcourseExample example);

    int deleteByPrimaryKey(TcourseKey key);

    int insert(TcourseKey record);

    int insertSelective(TcourseKey record);

    List<TcourseKey> selectByExample(TcourseExample example);

    int updateByExampleSelective(@Param("record") TcourseKey record, @Param("example") TcourseExample example);

    int updateByExample(@Param("record") TcourseKey record, @Param("example") TcourseExample example);
}