package com.company;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	// write your code here



        try {
          Files.createFile(Paths.get("movieList.txt"));
        } catch (FileAlreadyExistsException faee) {
            Paths.get("my-file.txt");
        }


        fileHandler file = new fileHandler();
       // personList per = new personList();
        Scanner in = new Scanner(System.in);
        gui gui = new gui();
        gui.loadGui();





        }

    }




