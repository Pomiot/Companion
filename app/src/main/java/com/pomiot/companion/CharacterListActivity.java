package com.pomiot.companion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.pomiot.companion.adapters.CharacterAdapter;

/**
 * Created by Tomasz on 31.01.2016.
 */
public class CharacterListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_list);

        initializeCharactersList();

    }

    private void initializeCharactersList() {

        ListView listView = (ListView) findViewById(R.id.character_list);

        final CharacterAdapter adapter = new CharacterAdapter(this);

        listView.setAdapter(adapter);
    }

}
