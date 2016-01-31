package com.pomiot.companion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.pomiot.companion.model.*;
import com.pomiot.companion.model.Character;

import org.w3c.dom.Text;

public class CharacterDetailsActivity extends AppCompatActivity {

    public static final String CHARACTER_EXTRA_KEY = "character";

    Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_details);

        Intent i = getIntent();
        character = (Character) i.getExtras().getSerializable(CHARACTER_EXTRA_KEY);

        showCharacter(character);
    }

    private void showCharacter(Character character) {

        TextView title = (TextView) findViewById(R.id.character_title);
        ImageView photo = (ImageView) findViewById(R.id.photo);
        TextView description = (TextView) findViewById(R.id.description_content);
        TextView characteristics = (TextView) findViewById(R.id.characteristics_content);
        TextView skills = (TextView) findViewById(R.id.skills_content);
        TextView perks = (TextView) findViewById(R.id.perks_content);

        title.setText(character.getCharacterName());
        photo.setImageResource(character.getPhotoResId());
        description.setText(character.getDescription());
        characteristics.setText(character.getAttributeList().toString());
        skills.setText(character.getSkillList().toString());
        perks.setText(character.getPerksList().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_character_details, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.modify_character: {
                startModifyCharacterActivity();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }

    }

    private void startModifyCharacterActivity() {
        Intent intent = new Intent(this, ModifyCharacterActivity.class);
        intent.putExtra(CHARACTER_EXTRA_KEY, character);
        startActivity(intent);
    }
}
