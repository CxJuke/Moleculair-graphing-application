package nl.bioinf.jpro_pkam.grappaweb.Database;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class create the database, connect to the database, insert information into the database and make possible
 * to search a molecule in the database.
 *
 * @author Jouke Profijt & Priscilla Kamphuis
 */
public class databaseConnector {
    /**
     * This function creates the database
     * @param filename contain the database as file
     * @throws SQLException if something went wrong
     */

    public static void create(String filename) throws SQLException {



        Connection connection = new nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector().connect(filename);


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

    /**
     *This function makes connection with the database
     * @param database Name of the database
     * @return the connection data to connect with the database (username and password)
     * @throws SQLException if something went wrong with the connection
     */
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

    /**
     * This function inserts the molecules into a table from the database
     * @param moleculeName name of molecule to insert in a table
     * @param Molecule name of table to insert molecule
     * @param database Name of the database
     */
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

    /**
     *This function creates sql search query. The table is always the same: molecules and the name is caught in SearchServlet
     * @param name The name of the molecule in the database
     * @param database Name of the database
     * @return arraylist string with results
     */

    public ArrayList<String> search(String name, String database) {
        String query = "SELECT name from molecules WHERE name LIKE '%" + name + "%'";
        ArrayList<String> names = new ArrayList<>();

        try (Connection connection = this.connect(database);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                names.add(rs.getString(1));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return names;

    }

    /**
     * This function finds the build string for the selected molecule
     * @param name Moleculename saved in the database
     * @param database Name of the database
     * @return molecule build string
     */
    public String getMolecule(String name, String database) {
        String query = "SELECT molecule from molecules WHERE name == '" + name + "'";
        String molecule = "";

        try (Connection connection = this.connect(database);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            molecule = rs.getString(1);
            System.out.println("molecule = " + molecule);



            } catch (SQLException e) {
            System.out.println(e.getMessage());


        } return molecule;
    }

    /**
     * This function checks if the database doesnt contain the name or molecule
     * @param name molecule name
     * @param molecule molecule build string
     * @param database database name
     * @return
     */

    public boolean checkExisting(String name, String molecule, String database){
        String queryName = "SELECT * FROM molecules where name == '" + name + "'";
        String queryMolecule = "SELECT * FROM molecules where molecule == '" + molecule + "'";
        boolean empty = false;

        try (Connection connection = this.connect(database);
            PreparedStatement pstmtName = connection.prepareStatement(queryName)) {
            ResultSet rs = pstmtName.executeQuery();

            PreparedStatement pstmtMolecule = connection.prepareStatement(queryMolecule);
            ResultSet rsM = pstmtMolecule.executeQuery();

            if (!rs.next() && !rsM.next()) {
                empty = false;
            } else {
                empty = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return empty;
    }
}