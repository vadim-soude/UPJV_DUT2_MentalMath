package fr.vadimsoude.mentalcounting.database;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper{

    public CalculBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, "Calculs", 1);
    }

    @Override
    protected String getCreationSql() {
        return null;
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
