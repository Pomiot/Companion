package com.pomiot.companion.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import static com.pomiot.companion.repositories.DbConstants.*;
import com.pomiot.companion.model.Character;

/**
 * Created by Pomiot on 31.01.2016.
 */
public class CharacterDatabase implements CharacterRepository {
    private CharacterDbHelper characterDbHelper;

    public CharacterDatabase(Context context) {
        this.characterDbHelper = new CharacterDbHelper(context);
    }

    public void addCharacter(Character character) {
        SQLiteDatabase db = characterDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, character.getCharacterName());
        values.put(COLUMN_PROFESSION, character.getProfession());
        values.put(COLUMN_DESCRIPTION, character.getDescription());
        values.put(COLUMN_CHARACTERISTICS, character.getAttributeList());
        values.put(COLUMN_SKILLS, character.getSkillList());
        values.put(COLUMN_PERKS, character.getPerksList());
        values.put(COLUMN_PHOTOID, character.getPhotoResId());

        db.insert(TABLE_NAME, null, values);
    }

    public Character getCharacter(int position) {
        SQLiteDatabase db = characterDbHelper.getReadableDatabase();

        String[] projection = {
                COLUMN_NAME, COLUMN_PROFESSION, COLUMN_DESCRIPTION, COLUMN_CHARACTERISTICS, COLUMN_SKILLS, COLUMN_PERKS, COLUMN_PHOTOID
        };

        String sortOrder = COLUMN_NAME + " DESC";

        Cursor cursor = db.query(
                TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        cursor.moveToPosition(position);

        String name = cursor.getString(0);
        String profession = cursor.getString(1);
        String description = cursor.getString(2);
        String characteristics = cursor.getString(3);
        String skills = cursor.getString(4);
        String perks = cursor.getString(5);
        int photoid = cursor.getInt(6);

        return new Character(photoid, name, description, profession, characteristics, skills, perks);
    }

    public int getCharactersNumber() {
        SQLiteDatabase db =  characterDbHelper.getReadableDatabase();

        return (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME, null, null);
    }
}
