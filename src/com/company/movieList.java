package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by simon blank on 2016-12-12.
 */
public class movieList {

    ArrayList<movies> movie = new ArrayList<movies>();


    String filename="movieList.txt";
    File textFile = new File(filename);
    Scanner scanFile = new Scanner(textFile).useDelimiter("@@@");
    fileHandler fileHandler = new fileHandler();
    String info;
    int sentmovies=0;




    public movieList() throws IOException, ClassNotFoundException {   //// constructor

/////////////////////////////// read from file /////////////////////////////////
        while (scanFile.hasNext()) {
            info = scanFile.next();
            if(sentmovies>0){info= info.substring(2); }
            sentmovies++;
            addMovies(info);

        }

    }



    public String getmovies(){

        Iterator itr = movie.iterator();
        int movienumber =1;

        StringBuilder media = new StringBuilder("name genre rating mediatype\n");

        while (itr.hasNext()) {
            movies movies = (movies) itr.next();
            media.append("#" +movienumber +" "+ movies.getName() +" "+ movies.getGenre() +" "+ movies.getRating()+" "+ movies.getType()+"\n");
            movienumber++;
        }
        return media.toString();

    }

    public void addMovies(String info){
        String  name="",genre="", type="";
        int turn=0 , rating=0 ;

        Scanner split = new Scanner(info).useDelimiter("@@");


        while (split.hasNext()){
            if(turn==0)name=split.next();
            if(turn==1)genre=split.next();
            if(turn==2)rating=Integer.parseInt(split.next());
            if(turn==3)type=split.next();

            turn++;
        }




        movies movies = new movies(name , genre,rating,type);
        movie.add(movies);
    }

    public void removeMovie(int who){
        movie.remove(who-1);
        fileHandler.filedeleter();



        Iterator itr = movie.iterator();
        while (itr.hasNext()) {
            movies movies =(movies) itr.next();
            info =movies.getName() +"@@"+ movies.getGenre() +"@@"+ movies.getRating() +"@@" +movies.getType();

            fileHandler.addMovie(info);
        }


    }


}
