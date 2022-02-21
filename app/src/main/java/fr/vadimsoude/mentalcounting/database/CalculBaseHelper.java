package fr.vadimsoude.mentalcounting.database;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper{

    public CalculBaseHelper(Context context) {
        super(context, "Calculs", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS historique (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDao.INDEX_PREMIER_ELEMENT + " INTEGER NOT NULL," +
                CalculDao.INDEX_DEUXIEME_ELEMENT + " INTEGER NOT NULL," +
                CalculDao.INDEX_SYMBOL + " VARCHAR(255) NOT NULL," +
                CalculDao.INDEX_RESULTAT + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
