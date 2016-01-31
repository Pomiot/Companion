package com.pomiot.companion.repositories;

import android.content.Context;

import com.pomiot.companion.R;
import com.pomiot.companion.model.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pomiot on 31.01.2016.
 */
public class DummyCharacterRepository implements CharacterRepository {

    private static final List<Character> CHARACTERS = new ArrayList<>();

    public DummyCharacterRepository(Context context) {
        CHARACTERS.clear();
        CHARACTERS.add(new Character(R.drawable.recipe1, "Bartosz", "Asdf", "Barbarzyńca"));
        CHARACTERS.add(new Character(R.drawable.recipe2, "Maciej", "Asdf", "Czarodziej"));
        CHARACTERS.add(new Character(R.drawable.recipe3, "Andrzej", "Asdf", "Kapłan"));
        CHARACTERS.add(new Character(R.drawable.recipe4, "Karol", "Asdf", "Złodziej"));
    }

    @Override
    public Character getCharacter(int position) {
        return CHARACTERS.get(position);
    }

    @Override
    public int getCharactersNumber() {
        return CHARACTERS.size();
    }


}
