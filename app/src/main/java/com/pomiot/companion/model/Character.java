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

    private String attributeList;
    private String skillList;
    private String perksList;

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

    public String getAttributeList() {
        return attributeList;
    }

    public String getSkillList() {
        return skillList;
    }

    public String getPerksList() {
        return perksList;
    }

    public Character(int photoResId, String characterName, String description, String profession) {
        this.photoResId = photoResId;
        this.characterName = characterName;
        this.description = description;
        this.profession = profession;

        String atts = "Atrybut1 5\nAtrybut2 8\nAtrybut3 3\n";
        String sklls = "Skill1 5\nSkill2 8\nSkill3 3\n";
        String prks = "Perk1\nPerk2\nPerk3";

        attributeList = atts;
        skillList = sklls;
        perksList = prks;
    }

    public Character(int photoResId, String characterName, String description, String profession, String attributeList, String skillList, String perksList) {
        this.photoResId = photoResId;
        this.characterName = characterName;
        this.description = description;
        this.profession = profession;
        this.attributeList = attributeList;
        this.skillList = skillList;
        this.perksList = perksList;
    }
}
