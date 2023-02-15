package com.lab5.business_entities;

import java.util.Date;
import java.util.HashSet;

public class CollectionData {

    String type;
    long initialisationDate;
    int size;
    boolean isEmpty;

    public CollectionData (String type, long initialisationDate, int size, boolean isEmpty) {
        this.type = type;
        this.initialisationDate = initialisationDate;
        this.size = size;
        this.isEmpty = isEmpty;
    }

}
