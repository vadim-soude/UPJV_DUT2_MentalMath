package fr.vadimsoude.mentalcounting.database;

import android.content.Context;

public class ScoreboardBaseHelper extends DataBaseHelper{

    public ScoreboardBaseHelper(Context context) {
        super(context, "Scoreboard", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS Scoreboard (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreboardDao.INDEX_NAME + " VARCHAR(255) NOT NULL," +
                ScoreboardDao.INDEX_SCORE + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
