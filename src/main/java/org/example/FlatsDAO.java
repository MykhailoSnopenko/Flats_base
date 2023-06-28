package org.example;

import java.util.List;

public interface FlatsDAO {
    void createTable();
    void addFlat(String district, String street, int square, int numberRooms, int price);
    List<Flat> getAll();
    List<Flat> selectFlatByPrice (int price);
//    List<Flat> selectFlatBySquare (int square);
}
