package base.mapper;

import base.model.Score;
import base.model.ScoreExample;
import base.model.ScoreKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(ScoreKey key);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(ScoreKey key);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}