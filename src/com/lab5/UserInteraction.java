package com.lab5;

import com.lab5.business_entities.CollectionData;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserInteraction {

    public void start() {
        FileProcessing fileProcessing = new FileProcessing();
        CollectionManagement collectionManagement = new CollectionManagement();


        //TODO: errors processing
        //Locale locale = new Locale("en");
        //ResourceBundle r = ResourceBundle.getBundle("command_line");
        //System.out.println(r.getString("filegreeting"));
        System.out.println("Type in the name of the file");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        collectionManagement.setCollection(fileProcessing.readFile(fileName));

        System.out.println("Type in the command:");
        String command = in.nextLine();
        while(!command.equals("exit")) {
            if (command.equals("info")) {
                printCollectionInfo(collectionManagement.info());
            }
            System.out.println("Type in the command:");
            command = in.nextLine();
        }
        in.close();
    }



    private void printCollectionInfo(CollectionData collectionData) {
        System.out.println("Тип коллекции: " + collectionData.getType());
        System.out.println("Дата инициализации коллекции: " + collectionData.getInitialisationDate());
        System.out.println("Размер коллекции: " + collectionData.getSize());
        System.out.println("Пуста ли коллекция: " + collectionData.isEmpty());
    }

}
