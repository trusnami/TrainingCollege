package base.service;

import base.model.Score;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yugi on 2017/3/20.
 */
@Service
public interface ScoreService {

    boolean addScore(Score score) throws Exception;

    List<Score> getScoreByCourseid(int courseid) throws Exception;

}
