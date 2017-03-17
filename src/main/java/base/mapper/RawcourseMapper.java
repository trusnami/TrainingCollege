package base.mapper;

import base.model.Rawcourse;
import base.model.RawcourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RawcourseMapper {
    int countByExample(RawcourseExample example);

    int deleteByExample(RawcourseExample example);

    int deleteByPrimaryKey(Integer courseid);

    int insert(Rawcourse record);

    int insertSelective(Rawcourse record);

    List<Rawcourse> selectByExample(RawcourseExample example);

    Rawcourse selectByPrimaryKey(Integer courseid);

    int updateByExampleSelective(@Param("record") Rawcourse record, @Param("example") RawcourseExample example);

    int updateByExample(@Param("record") Rawcourse record, @Param("example") RawcourseExample example);

    int updateByPrimaryKeySelective(Rawcourse record);

    int updateByPrimaryKey(Rawcourse record);
}