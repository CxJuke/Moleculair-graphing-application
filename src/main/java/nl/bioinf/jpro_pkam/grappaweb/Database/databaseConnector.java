package nl.bioinf.jpro_pkam.grappaweb.Database;

import java.sql.*;
import java.util.ArrayList;

public class databaseConnector {

    public static void create(String filename) throws SQLException {



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

    private Connection connect(String database) throws SQLException {
        Connection connection = null;
        try {
            String driverClassName="org.sqlite.JDBC";
            Class.forName(driverClassName).newInstance();
            String url = "jdbc:sqlite:" + database;

            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e){
            throw new SQLException(e);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return connection;

        }


    public void insert(String moleculeName, String Molecule, String database) {
    String sql = "INSERT INTO molecules(name,molecule) VALUES(?,?)";

    try (Connection connection = this.connect(database);
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, moleculeName.toLowerCase());
        pstmt.setString(2, Molecule);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    }

    public ArrayList<String> search(String name, String database) {
        String query = "SELECT name from ? WHERE name LIKE ?";
        ArrayList<String> names = new ArrayList<>();

        try (Connection connection = this.connect(database);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, database);
            pstmt.setString(2, name.toLowerCase());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                names.add(rs.getString(1));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return names;

    }






    }
