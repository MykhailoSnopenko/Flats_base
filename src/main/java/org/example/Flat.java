package org.example;

public class Flat {
    @Id
    private int id;
    private String district;
    private String street;
    private int square;
    private int numberRooms;
    private int price;

    public Flat(String district, String street, int square, int numberRooms, int price) {
        this.district = district;
        this.street = street;
        this.square = square;
        this.numberRooms = numberRooms;
        this.price = price;
    }
    public Flat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", square=" + square +
                ", numberRooms=" + numberRooms +
                ", price=" + price +
                '}' + System.lineSeparator();
    }
}
