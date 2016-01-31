package com.pomiot.companion.repositories;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_CHARACTERISTICS;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_DESCRIPTION;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_NAME;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_PERKS;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_PHOTOID;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_PROFESSION;
import static com.pomiot.companion.repositories.DbConstants.COLUMN_SKILLS;
import static com.pomiot.companion.repositories.DbConstants.TABLE_NAME;
import static com.pomiot.companion.repositories.DbConstants.DATABASE_NAME;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CharacterDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PROFESSION + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_CHARACTERISTICS + " TEXT, " +
                    COLUMN_SKILLS + " TEXT, " +
                    COLUMN_PERKS + " TEXT, " +
                    COLUMN_PHOTOID + " INTEGER);";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public CharacterDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
    }

}