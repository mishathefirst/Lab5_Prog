package com.lab5;

import com.lab5.business_entities.CollectionData;

import java.util.*;

public class UserInteraction {

    public void start() {
        FileProcessing fileProcessing = new FileProcessing();
        CollectionManagement collectionManagement = new CollectionManagement();

        Queue<String> historyQueue = new ArrayDeque<>(11);


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
            switch (command) {
                case "info":
                    historyQueue.add("info");
                    printCollectionInfo(collectionManagement.info());
                    break;
                case "show":
                    historyQueue.add("show");
                    System.out.println(collectionManagement.show());
                    break;
                case "help":
                    historyQueue.add("help");
                    printHelpCommand();
                    break;
                case "add":
                    historyQueue.add("add");
                    printAddCommand();
                    break;
                case "history":
                    for (int i = 0; i < historyQueue.toArray().length; i++) {
                        System.out.println(historyQueue.toArray()[i]);
                    }
                    break;
                default:
                    System.out.println("Command not found. Type \"help\" to get information on an interaction with the program");
                    break;
            }
            System.out.println("Type in the command:");
            command = in.nextLine();
        }
        in.close();
    }



    private void printCollectionInfo(CollectionData collectionData) {
        System.out.println("Collection type: " + collectionData.getType());
        System.out.println("Collection initialisation date: " + new Date(collectionData.getInitialisationDate()));
        System.out.println("Collection size: " + collectionData.getSize());
        System.out.println("Is collection empty: " + collectionData.isEmpty());
    }

    private void printHelpCommand() {
        System.out.println("\"help\" - show info on the interaction with the program");
        System.out.println("\"show\" - show all elements of the collection");
        System.out.println("\"info\" - show info on the collection");
        System.out.println("\"add\" - add an element to the collection");
        System.out.println("\"update_id {element's number}\" - update an element of the collection by its id");
        System.out.println("\"remove_by_id {element's number}\" - remove an element from the collection by its id");
        System.out.println("\"clear\" - clear the collection");
        System.out.println("\"save\" - save changes into the file");
        System.out.println("\"execute_script {file name}\" - execute a script written in the same format as commands to the prgram");
        System.out.println("\"exit\" - leave the program without saving changes");
        System.out.println("\"history\" - show last 11 commands");
        System.out.println("\"add_if_min\" - add an element if it is the smallest in the collection");
        System.out.println("\"remove_lower\" - delete all elements from the collection that are lower than the current one.");

    }

    private void printAddCommand() {
        System.out.println("Print the name of the band you would like to add: ");

    }

}
