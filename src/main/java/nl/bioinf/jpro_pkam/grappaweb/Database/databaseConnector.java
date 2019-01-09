package nl.bioinf.jpro_pkam.grappaweb.Database;

import java.sql.*;

public class databaseConnector {

    public static void create(String filename) {
        Connection connection = new databaseConnector().connect(filename);


        String sql = "CREATE TABLE IF NOT EXISTS molecules (\n"
                + "name text NOT NULL, \n"
                + "molecule text UNIQUE\n"
                + ");";

        try (
                Statement stmt = connection.createStatement()) {
            stmt.execute(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Connection connect(String database) {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:src/main/webapp/data/" + database;

            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            } return connection;

        }


    public void insert(String moleculeName, String Molecule, String database) {
    String sql = "INSERT INTO molecules(name,molecule) VALUES(?,?)";

    try (Connection connection = this.connect(database);
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, moleculeName);
        pstmt.setString(2, Molecule);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    }






    }
