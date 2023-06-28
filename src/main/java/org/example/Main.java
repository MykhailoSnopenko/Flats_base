package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             Scanner sc = new Scanner(System.in))
        {
            FlatsDAO dao = new FlatsDAOImpl(conn);
            dao.createTable();

            while (true) {
                System.out.println("1: add flat");
                System.out.println("2: view flats");
                System.out.println("3: select all flats");
                System.out.println("4: select flats by price");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter flat district: ");
                        String district = sc.nextLine();
                        System.out.print("Enter flat street: ");
                        String street = sc.nextLine();
                        System.out.print("Enter flat square: ");
                        String eSquare = sc.nextLine();
                        int square = Integer.parseInt(eSquare);
                        System.out.print("Enter flat number rooms: ");
                        String eNumberRooms = sc.nextLine();
                        int numberRooms = Integer.parseInt(eNumberRooms);
                        System.out.print("Enter flat price: ");
                        String ePrice = sc.nextLine();
                        int price = Integer.parseInt(ePrice);

                        dao.addFlat(district, street, square, numberRooms, price);
                        break;
                    case "2":
                        List<Flat> list = dao.getAll();
                        for (Flat flat : list) {
                            System.out.println(flat);
                        }
                        break;
                    case "3":
                        System.out.println("All flats in the database : "
                                + dao.getAll());
                        break;
                    case "4":
                        System.out.println("Enter max price for selecting interested flats: ");
                        String ePriceMax = sc.nextLine();
                        int priceMax = Integer.parseInt(ePriceMax);
                        System.out.println("Flats with a price lower than the entered price: "
                                + dao.selectFlatByPrice(priceMax));
                        break;
                    default:
                        return;
                }
            }
        }
    }
}
