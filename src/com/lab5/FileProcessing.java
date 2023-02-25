package com.lab5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lab5.entities.MusicBand;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Scanner;

public class FileProcessing {

    /*
    String getFile() {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        in.close();
        return fileName;
    }
     */

    HashSet<MusicBand> getCollectionFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder fileContent = new StringBuilder();
        Gson gson = new Gson();
        HashSet<MusicBand> collection = new HashSet<>();

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String fileLine = fileScanner.nextLine();
                fileContent.append(fileLine);
            }
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type collectionType = new TypeToken<HashSet<MusicBand>>(){}.getType();
        collection = gson.fromJson(fileContent.toString(), collectionType);

        return collection;
    }




    void writeIntoFile() {

    }


}
