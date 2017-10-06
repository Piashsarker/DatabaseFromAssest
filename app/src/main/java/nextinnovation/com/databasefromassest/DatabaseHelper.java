package nextinnovation.com.databasefromassest;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by PT on 10/6/2017.
 */

public class DatabaseHelper  extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "university_database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}