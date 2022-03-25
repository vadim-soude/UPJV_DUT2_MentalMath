package fr.vadimsoude.mentalcounting.service;

import java.util.List;

import fr.vadimsoude.mentalcounting.database.ScoreboardDao;
import fr.vadimsoude.mentalcounting.entity.Score;

public class ScoreboardService {

    private ScoreboardDao scoreboardDao;

    public ScoreboardService(ScoreboardDao scoreboardDao) {
        this.scoreboardDao = scoreboardDao;
    }

    public List<Score> getScore(){
        return scoreboardDao.query();
    }

    public void storeScoreInDb(Score score){
        scoreboardDao.create(score);
    }
}
