package com.university.java.app;

import com.university.java.app.controller.Menu;
import com.university.java.app.util.Initialisation;

public class Main {

    public static void main(String[] args) {

//       Initialisation initialisation = new Initialisation();
//       initialisation.init();
        Menu menu = new Menu();
        menu.readMainMenu();
        menu.mainController();

    }
}
