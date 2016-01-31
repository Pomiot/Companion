package com.pomiot.companion.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 31.01.2016.
 */
public class Character implements Serializable {

    private int photoResId;

    private String characterName;
    private String description;
    private String profession;

    private List<Characteristic> attributeList;
    private List<Characteristic> skillList;
    private List<Characteristic> perksList;

    public int getPhotoResId() {
        return photoResId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getDescription() {
        return description;
    }

    public String getProfession() {
        return profession;
    }

    public List<Characteristic> getAttributeList() {
        return attributeList;
    }

    public List<Characteristic> getSkillList() {
        return skillList;
    }

    public List<Characteristic> getPerksList() {
        return perksList;
    }

    public Character(int photoResId, String characterName, String description, String profession) {
        this.photoResId = photoResId;
        this.characterName = characterName;
        this.description = description;
        this.profession = profession;

        attributeList = new ArrayList<>();
        skillList = new ArrayList<>();
        perksList = new ArrayList<>();

        attributeList.add(new Characteristic("Atrybut1", "5"));
        attributeList.add(new Characteristic("Atrybut2", "7"));
        attributeList.add(new Characteristic("Atrybut3", "3"));

        skillList.add(new Characteristic("Skill1", "2"));

        skillList.add(new Characteristic("Skill2", "1"));
        skillList.add(new Characteristic("Skill3", "4"));

        perksList.add(new Characteristic("Perk", "1"));
        perksList.add(new Characteristic("Perk", "2"));

    }


}
