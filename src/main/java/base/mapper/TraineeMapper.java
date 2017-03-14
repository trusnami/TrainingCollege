package base.mapper;

import base.model.Trainee;
import base.model.TraineeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraineeMapper {
    int countByExample(TraineeExample example);

    int deleteByExample(TraineeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Trainee record);

    int insertSelective(Trainee record);

    List<Trainee> selectByExample(TraineeExample example);

    Trainee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Trainee record, @Param("example") TraineeExample example);

    int updateByExample(@Param("record") Trainee record, @Param("example") TraineeExample example);

    int updateByPrimaryKeySelective(Trainee record);

    int updateByPrimaryKey(Trainee record);
}