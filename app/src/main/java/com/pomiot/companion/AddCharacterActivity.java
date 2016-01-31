package com.pomiot.companion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pomiot.companion.model.Character;
import com.pomiot.companion.repositories.CharacterDatabase;

public class AddCharacterActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_character);

        setupViews();
    }

    private void setupViews() {
        final EditText characterNameEditText = (EditText) findViewById(R.id.character_name_edit_text);
        final EditText descriptionEditText = (EditText) findViewById(R.id.description_edit_text);
        final EditText professionEditText = (EditText) findViewById(R.id.profession_edit_text);

        Button saveButton = (Button) findViewById(R.id.save_character_button);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String characterName = characterNameEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String profession = professionEditText.getText().toString();

                saveCharacter(new Character(R.drawable.recipe1, characterName, description, profession));
            }
        });
    }

    private void saveCharacter(Character character) {
        CharacterDatabase characterDatabase = new CharacterDatabase(this);
        characterDatabase.addCharacter(character);

        Toast.makeText(this, "Character " + character.getCharacterName() + " saved", Toast.LENGTH_SHORT).show();

        finish();
    }

}
