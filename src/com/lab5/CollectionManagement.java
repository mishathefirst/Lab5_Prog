package com.lab5;

import com.lab5.business_entities.CollectionData;
import com.lab5.entities.MusicBand;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CollectionManagement {

    private Set<MusicBand> collection;
    private final String collectionType;
    private final Date date = new Date();
    private final long initialisationDate;

    public CollectionManagement() {
        this.collection = new HashSet<>();
        this.collectionType = "HashSet";
        this.initialisationDate = date.getTime();
    }


    void add(MusicBand band) {
        collection.add(band);
    }

    void delete(MusicBand band) {
        collection.remove(band);
    }

    CollectionData info() {
        return new CollectionData(collectionType, initialisationDate, collection.size(), collection.isEmpty());
    }

    String show() {
        collection.iterator()
    }

    public void setCollection(HashSet<MusicBand> collection) {
        this.collection = collection;
    }

    public HashSet<MusicBand> getCollection() {
        return collection;
    }
}
