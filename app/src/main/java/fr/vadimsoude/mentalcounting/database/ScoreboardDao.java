package fr.vadimsoude.mentalcounting.database;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

import fr.vadimsoude.mentalcounting.entity.Score;

public class ScoreboardDao extends BaseDao<Score>{
    static String INDEX_NAME = "Name";
    static String INDEX_SCORE= "Score";

    public ScoreboardDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "Scoreboard";
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(INDEX_NAME,entity.getName());
        values.put(INDEX_SCORE,entity.getScore());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        cursor.moveToFirst();
        Score score = new Score();
        Integer indexName = cursor.getColumnIndex(INDEX_NAME);
        score.setName(cursor.getString(indexName));
        Integer indexScore = cursor.getColumnIndex(INDEX_SCORE);
        score.setScore(cursor.getInt(indexScore));
        return score;
    }

    public List<Score> query(){
        return super.query(null,null,INDEX_SCORE + " DESC, " + INDEX_NAME + " ASC");
    }
}