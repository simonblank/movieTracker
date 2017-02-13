package com.company;

import java.io.*;
import java.util.Formatter;


/**
 * Created by simon blank on 2016-12-12.
 */
public class fileHandler {

    private Formatter x;
    String filename="movieList.txt";


    public fileHandler() throws IOException, ClassNotFoundException {
    }


    public  void addMovie(String str){



        File f = new File(filename);
        try{
            FileReader fr = new FileReader(f);
            int ch = fr.read();

            FileWriter fw = new FileWriter(f, true);
            if(ch != -1)
                fw.write("\r\n");
            fw.write(str+"@@@");
            fw.close();
        }
        catch(Exception ex){
            try{
                FileWriter fw = new FileWriter(f);
                fw.write("New file");
                fw.close();
            }
            catch(Exception ex2){}
        }


    }

    public void filedeleter(){

        PrintWriter writer = null;
        try {writer = new PrintWriter(filename);

            writer.print("");
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }







}
