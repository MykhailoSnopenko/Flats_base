package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlatsDAOImpl implements FlatsDAO{
    private final Connection conn;

    public FlatsDAOImpl (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createTable() {
        try {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS Flats");
                st.execute("CREATE TABLE Flats (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                        "district VARCHAR(30) NOT NULL, " +
                        "street VARCHAR(30) NOT NULL, " +
                        "square INT NOT NULL, " +
                        "numberRooms INT NOT NULL, " +
                        "price INT NOT NULL)");
//                String district, String street, int square, int numberRooms, int price
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addFlat(String district, String street, int square, int numberRooms, int price) {
        try {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO Flats (district, street, square, numberRooms, price) VALUES(?, ?, ?, ?, ?)")) {
                st.setString(1, district);
                st.setString(2, street);
                st.setInt(3, square);
                st.setInt(4, numberRooms);
                st.setInt(5, price);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Flat> getAll() {
        List<Flat> result = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Flats")) {
                    while (rs.next()) {
                        Flat flat = new Flat();

                        flat.setId(rs.getInt(1));
                        flat.setDistrict(rs.getString(2));
                        flat.setStreet(rs.getString(3));
                        flat.setSquare(rs.getInt(4));
                        flat.setNumberRooms(rs.getInt(5));
                        flat.setPrice(rs.getInt(6));

                        result.add(flat);
                    }
                }
            }

            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Flat> selectFlatByPrice(int price) {
        List<Flat> result = new ArrayList<>();
        try{
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Flats WHERE price <= " + price)) {
                    while (rs.next()) {
                        Flat flat = new Flat();
                        flat.setId(rs.getInt(1));
                        flat.setDistrict(rs.getString(2));
                        flat.setStreet(rs.getString(3));
                        flat.setSquare(rs.getInt(4));
                        flat.setNumberRooms(rs.getInt(5));
                        flat.setPrice(rs.getInt(6));
                        result.add(flat);
                    }
                }
            }
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
