package com.lab5;

import com.lab5.business_entities.CollectionData;
import com.lab5.entities.Coordinates;
import com.lab5.entities.MusicBand;
import com.lab5.entities.MusicGenre;
import com.lab5.entities.Studio;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Long.getLong;

public class UserInteraction {

    FileProcessing fileProcessing = new FileProcessing();
    CollectionManagement collectionManagement = new CollectionManagement();
    Scanner in = new Scanner(System.in);

    public void start() {

        Queue<String> historyQueue = new ArrayDeque<>(11);


        //TODO: errors processing
        //Locale locale = new Locale("en");
        //ResourceBundle r = ResourceBundle.getBundle("command_line");
        //System.out.println(r.getString("filegreeting"));
        System.out.println("Type in the name of the file");
        String fileName = in.nextLine();
        if (fileProcessing.readCollectionFromFile(fileName) == null) {
            collectionManagement.setCollection(new HashSet<MusicBand>());
        } else {
            collectionManagement.setCollection(fileProcessing.readCollectionFromFile(fileName));
        }


        System.out.println("Type in the command:");
        String command = in.nextLine();
        while(!command.equals("exit")) {
            switch (command) {
                case "info":
                    historyUpdate(historyQueue, "info");
                    printCollectionInfo(collectionManagement.info());
                    break;
                case "show":
                    historyUpdate(historyQueue, "show");
                    System.out.println(collectionManagement.show());
                    break;
                case "help":
                    historyUpdate(historyQueue, "help");
                    printHelpCommand();
                    break;
                case "add":
                    historyUpdate(historyQueue, "add");
                    printAddCommand();
                    break;
                case "save":
                    historyUpdate(historyQueue, "save");
                    saveCollection(fileName);
                    break;
                case "history":
                    historyUpdate(historyQueue, "history");
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

        MusicGenre genre;

        System.out.println("Print the name of the band you would like to add: ");
        //Scanner addScanner = new Scanner(System.in);
        String bandName = in.nextLine();
        System.out.println("Print the the coordinates of the band in a format {xx,xx.xx}: ");
        String[] coordinatesString = in.nextLine().split(",");
        int bandCoordinateX = Integer.parseInt(coordinatesString[0]);
        double bandCoordinateY = Double.parseDouble(coordinatesString[1]);
        System.out.println("Type in the number of participants of the band: ");
        int numberOfParticipants = Integer.parseInt(in.nextLine());
        System.out.println("Choose the genre of the musical band within ROCK, JAZZ, PUNK-ROCK or skip the question if neither of the answers are appropriate:");
        String userGenre = in.nextLine();
        if (userGenre.equals("ROCK")) {
            genre = MusicGenre.ROCK;
        } else if (userGenre.equals("JAZZ")) {
            genre = MusicGenre.JAZZ;
        } else if (userGenre.equals("PUNK-ROCK")) {
            genre = MusicGenre.PUNK_ROCK;
        } else {
            genre = null;
        }
        System.out.println("Type in the name of the studio:");
        String studioName = in.nextLine();

        collectionManagement.add(new MusicBand(collectionManagement.getCollection().size() + 1, bandName,
                new Coordinates(bandCoordinateX, bandCoordinateY), LocalDate.now(),
                numberOfParticipants, genre, new Studio(studioName)));

        System.out.println("Element successfully added!");
    }

    private void saveCollection(String fileName) {
        System.out.println("Saving collection into file...");
        fileProcessing.writeCollectionIntoFile(collectionManagement.getCollection(), fileName);
        System.out.println("Successfully saved!");
    }

    private void historyUpdate(Queue<String> historyQueue, String command) {
        historyQueue.add(command);
        if (historyQueue.size() > 11) {
            historyQueue.poll();
        }
    }

}
