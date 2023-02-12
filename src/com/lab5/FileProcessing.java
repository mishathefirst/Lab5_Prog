package com.lab5;

import com.lab5.entities.MusicBand;

import java.util.HashSet;
import java.util.Scanner;

public class FileProcessing {

    String getFile() {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        in.close();
        return fileName;
    }

    HashSet<MusicBand> readFile(String fileName) {

    }

    void writeIntoFile() {

    }


}
