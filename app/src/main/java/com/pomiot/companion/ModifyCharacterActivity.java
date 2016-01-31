package com.pomiot.companion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pomiot.companion.model.Character;
import com.pomiot.companion.repositories.CharacterDatabase;

/**
 * Created by Tomasz on 31.01.2016.
 */
public class ModifyCharacterActivity extends AppCompatActivity {

    Character character;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();

        character = (Character) i.getExtras().getSerializable(CharacterDetailsActivity.CHARACTER_EXTRA_KEY);

        setContentView(R.layout.modify_character);

        setupViews(character);

    }


    private void setupViews(Character character) {

        final EditText characterNameEditText = (EditText) findViewById(R.id.character_name_edit_text);
        final EditText descriptionEditText = (EditText) findViewById(R.id.description_edit_text);
        final EditText professionEditText = (EditText) findViewById(R.id.profession_edit_text);
        final EditText characteristicsEditText = (EditText) findViewById(R.id.characteristics_edit_text);
        final EditText skillsEditText = (EditText) findViewById(R.id.skills_edit_text);
        final EditText perksEditText = (EditText) findViewById(R.id.perks_edit_text);

        characterNameEditText.setText(character.getCharacterName());
        descriptionEditText.setText(character.getDescription());
        characteristicsEditText.setText(character.getAttributeList());
        professionEditText.setText(character.getProfession());
        skillsEditText.setText(character.getSkillList());
        perksEditText.setText(character.getPerksList());

        Button saveButton = (Button) findViewById(R.id.save_modified_button);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String characterName = characterNameEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String profession = professionEditText.getText().toString();
                String characteristics = characteristicsEditText.getText().toString();
                String skills = skillsEditText.getText().toString();
                String perks = skillsEditText.getText().toString();

                modifyCharacter(new Character(R.drawable.recipe1, characterName, description, profession, characteristics, skills, perks));
            }
        });
    }

    private void modifyCharacter(Character updatedCharacter) {
        CharacterDatabase characterDatabase = new CharacterDatabase(this);
        characterDatabase.modifyCharacter(updatedCharacter);

        Toast.makeText(this, "Character " + character.getCharacterName() + " saved", Toast.LENGTH_SHORT).show();

        finish();
    }

}

