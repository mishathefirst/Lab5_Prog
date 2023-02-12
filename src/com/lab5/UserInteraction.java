package com.lab5;

public class UserInteraction {

    public void start() {
        FileProcessing fileProcessing = new FileProcessing();
        CollectionManagement collectionManagement = new CollectionManagement();

        System.out.println("Type in the name of the file:");
        String fileName = fileProcessing.getFile();
        collectionManagement.setCollection(fileProcessing.readFile(fileName));


    }

}
