package com.pomiot.companion.repositories;

import com.pomiot.companion.model.*;

/**
 * Created by Pomiot on 31.01.2016.
 */
public interface CharacterRepository {
    com.pomiot.companion.model.Character getCharacter(int position);

    int getCharactersNumber();
}
