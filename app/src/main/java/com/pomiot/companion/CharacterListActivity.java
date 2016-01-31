package com.pomiot.companion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pomiot.companion.adapters.CharacterAdapter;
import com.pomiot.companion.model.Character;

public class CharacterListActivity extends AppCompatActivity {

    CharacterAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_list);

        adapter = new CharacterAdapter(this);

        initializeCharactersList();

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_character: {
                startAddCharacterActivity();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }

    }

    private void startAddCharacterActivity() {
        Intent i = new Intent(this, AddCharacterActivity.class);
        startActivity(i);
    }


    private void initializeCharactersList() {

        ListView listView = (ListView) findViewById(R.id.character_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Character character = adapter.getItem(position);
                showCharacter(character);
            }
        });
    }

    private void showCharacter(Character character) {

        Intent i = new Intent(this, CharacterDetailsActivity.class);

        i.putExtra(CharacterDetailsActivity.CHARACTER_EXTRA_KEY, character);

        startActivity(i);

    }

}
