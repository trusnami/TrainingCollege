package base.serviceImpl;

import base.mapper.ScoreMapper;
import base.model.Score;
import base.model.ScoreExample;
import base.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugi on 2017/3/20.
 */
@Service
public class ScoreServiceImpl implements ScoreService{

    @Resource
    ScoreMapper scoreMapper;

    @Override
    public boolean addScore(Score score) throws Exception {
        int result = scoreMapper.insert(score);

        return false;
    }

    @Override
    public List<Score> getScoreByCourseid(int courseid) throws Exception {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andCourseidEqualTo(courseid);
        List<Score> scoreList = scoreMapper.selectByExample(scoreExample);

        return scoreList;
    }
}
