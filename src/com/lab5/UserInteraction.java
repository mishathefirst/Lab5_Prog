package com.lab5;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserInteraction {

    public void start() {
        FileProcessing fileProcessing = new FileProcessing();
        CollectionManagement collectionManagement = new CollectionManagement();

        //TODO: errors processing
        //Locale locale = new Locale("en");
        ResourceBundle r = ResourceBundle.getBundle("command_line");
        System.out.println(r.getString("filegreeting"));
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        collectionManagement.setCollection(fileProcessing.readFile(fileName));

        System.out.println("Type in the command:");
        String command = in.nextLine();
        while(!command.equals("exit")) {
            System.out.println("Next String");
            command = in.nextLine();
        }
        in.close();
    }

}
