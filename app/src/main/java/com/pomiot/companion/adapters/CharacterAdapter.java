package com.pomiot.companion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pomiot.companion.R;
import com.pomiot.companion.model.Character;
import com.pomiot.companion.repositories.CharacterDatabase;
import com.pomiot.companion.repositories.CharacterRepository;
import com.pomiot.companion.repositories.DummyCharacterRepository;

/**
 * Created by Tomasz on 31.01.2016.
 */
public class CharacterAdapter extends BaseAdapter {

    CharacterRepository repository;
    Context context;

    public CharacterAdapter(Context context) {
        this.context = context;
        this.repository = new CharacterDatabase(context);
    }

    @Override
    public int getCount() {
        return repository.getCharactersNumber();
    }

    @Override
    public Character getItem(int position) {
        return repository.getCharacter(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View characterView;

        if(convertView == null){
            characterView = LayoutInflater.from(context).inflate(R.layout.character_row, parent, false);
        }
        else{
            characterView = convertView;
        }

        bindCharacterToView(getItem(position), characterView);
        return characterView;
    }

    private void bindCharacterToView(Character character, View characterView) {
        ImageView characterPhoto = (ImageView) characterView.findViewById(R.id.character_photo);
        characterPhoto.setImageResource(character.getPhotoResId());

        TextView characterLabel = (TextView) characterView.findViewById(R.id.character_label);
        characterLabel.setText(character.getCharacterName());

        TextView characterProfession = (TextView) characterView.findViewById(R.id.character_profession);
        characterProfession.setText(character.getProfession());
    }


}
