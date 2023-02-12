package com.lab5;

import com.lab5.entities.MusicBand;

import java.util.HashSet;

public class CollectionManagement {

    private HashSet<MusicBand> collection;

    public void setCollection(HashSet<MusicBand> collection) {
        this.collection = collection;
    }

    public HashSet<MusicBand> getCollection() {
        return collection;
    }
}
