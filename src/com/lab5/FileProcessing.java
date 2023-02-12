package com.lab5;

import java.util.Scanner;

public class FileProcessing {

    String getFile() {
        Scanner in = new Scanner(System.in);
        System.out.println("Type in the name of the file:");
        String fileName = in.nextLine();
        in.close();
        return fileName;
    }



}
