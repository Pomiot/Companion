package com.pomiot.companion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tomasz on 31.01.2016.
 */
public class Character implements Serializable {

    private String characterName;

    private String description;

    private String profession;

    private List<Characteristic> attributeList;

    private List<Characteristic> skillList;

    private List<Characteristic> perksList;

}
