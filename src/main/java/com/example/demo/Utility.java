package com.example.demo;

import java.util.Scanner;

public class Utility {

    //metoden går ud fra at der er en arraylist der hedder users, med alle brugerne i.
    //metoden skal rettes til så den tilgår databasen og skal derefter returnere selve objektet
    private static User login(String username, String password) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername())== username.toLowerCase() && users.get(i).getPassword()==password.toLowerCase()) {
                return users.get(i);
            }
        }

    }
}
