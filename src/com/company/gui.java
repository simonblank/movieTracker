package com.company;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by simon blank on 2016-12-13.
 */
public class gui {


    movieList movieList = new movieList();
    fileHandler file = new fileHandler();
    JTextArea textField = new JTextArea(); // skapa en text field + properties
    JFrame frame = new JFrame("MovieTracker"); /// skapa en frame
    JPanel panel = new JPanel(); /// skapa en panel
    JComboBox<String> genredropDownMenu =new JComboBox<String>();
    JComboBox<String> mediaDropDownMenu =new JComboBox<String>();
    JComboBox<String> ratingdropDownMenu =new JComboBox<String>();
    JTextArea nameArea = new JTextArea();

///// panelen ligger på framen så för att lägga till något måste man lägga saken på panelen

    public gui() throws IOException, ClassNotFoundException {









    } /// le constructor

    public void loadGui(){
        panelProperties();
        listTextArea();

        removebutton();
        refreshbutton();
        nameField();
        ratingDropDownMenu();
        genreTypeDropDownMenu();
        mediaTypeDropDownMenu();
        addbutton();
        exitbutton();


        frameProperties();
    }

    public void panelProperties(){
        panel.setBackground(Color.lightGray); // gör panelen svart
        frame.getContentPane().add(panel); // lägg panelen på framen
    }

    public void listTextArea(){
        textField.setPreferredSize(new Dimension(350,950));
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setEditable(false);
        panel.add(textField); // lägg till på panelen


        JScrollPane scrollPane = new JScrollPane(textField);// scroll bar till text arean
        scrollPane.setPreferredSize(new Dimension(380,400));
        panel.add(scrollPane);
    }




    public void addToTextArea(){
       textField.append(movieList.getmovies());
    }

    public void frameProperties(){

        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void refreshbutton(){
        JButton button = new JButton("refresh list!");//// skapar en button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
                addToTextArea();
            }
        });


        panel.add(button);   // lägg till buttton


    }

    public void removebutton(){
        JButton button = new JButton("remove!");//// skapar en button


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = JOptionPane.showInputDialog("enter number of movie to remove");
                int y = Integer.parseInt(x);
                movieList.removeMovie(y);
            }
        });
        panel.add(button);   // lägg till buttton


    }

    public void addbutton(){
        JButton button = new JButton("add!");//// skapar en button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = nameArea.getText() + "@@"+ genredropDownMenu.getSelectedItem() + "@@" + ratingdropDownMenu.getSelectedItem() + "@@" + mediaDropDownMenu.getSelectedItem();
                nameArea.setText(null);
                file.addMovie(info);
                movieList.addMovies(info);
            }
        });
        panel.add(button);   // lägg till buttton


    }

    public void exitbutton(){

        JButton button = new JButton("exit!");//// skapar en button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        panel.add(button);   // lägg till buttton

    }

    public void mediaTypeDropDownMenu(){
        mediaDropDownMenu.addItem("film");
        mediaDropDownMenu.addItem("serie");
        mediaDropDownMenu.addItem("anime");
        mediaDropDownMenu.addItem("cartoon");
        panel.add(mediaDropDownMenu);

    }

    public void genreTypeDropDownMenu(){
        genredropDownMenu.addItem("adventure");
        genredropDownMenu.addItem("horror");
        genredropDownMenu.addItem("action");
        genredropDownMenu.addItem("comedy");
        genredropDownMenu.addItem("drama");
        genredropDownMenu.addItem("survival");
        genredropDownMenu.addItem("scifi");
        genredropDownMenu.addItem("fantasy");
        panel.add(genredropDownMenu);

        }

    public void ratingDropDownMenu(){
        ratingdropDownMenu.addItem("1");
        ratingdropDownMenu.addItem("2");
        ratingdropDownMenu.addItem("3");
        ratingdropDownMenu.addItem("4");
        ratingdropDownMenu.addItem("5");
        ratingdropDownMenu.addItem("6");
        ratingdropDownMenu.addItem("7");
        ratingdropDownMenu.addItem("8");
        ratingdropDownMenu.addItem("9");
        ratingdropDownMenu.addItem("10");
        panel.add(ratingdropDownMenu);

        }

    public void nameField(){

        nameArea.setPreferredSize(new Dimension(200,20));
        panel.add(nameArea);


    }







}








