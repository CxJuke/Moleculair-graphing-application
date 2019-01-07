package nl.bioinf.jpro_pkam.grappaweb.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class databaseConnector {

    private Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:src/main/webapp/data/molecules.sqlite";

            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            } return connection;

        }


    public void insert(String moleculeName, String Molecule) {
    String sql = "INSERT INTO molecules(name,molecule) VALUES(?,?)";

    try (Connection connection = this.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, moleculeName);
        pstmt.setString(2, Molecule);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    }
}
