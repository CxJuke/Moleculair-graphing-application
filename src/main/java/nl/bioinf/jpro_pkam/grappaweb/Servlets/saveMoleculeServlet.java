package nl.bioinf.jpro_pkam.grappaweb.Servlets;

import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This class get the typed molecule and the moleculename from the save modal and connect with the database to save the
 * molecule.
 *
 * @author Jouke Profijt & Priscilla Kamphuis
 */
@WebServlet(name = "saveMoleculeServlet", urlPatterns = "/save.molecule")
public class saveMoleculeServlet extends HttpServlet {
    /**
     * This function get the molecule and moleculename parameter from the form, connect with the database and save the
     * molecule in a table in the database. If something went wrong with connecting the database, this function prints
     * a user-friendly error.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String molecule = request.getParameter("SaveMolecule");
        String name = request.getParameter("moleculeName");
        String database = getServletContext().getInitParameter("database");
        databaseConnector db = new databaseConnector();
        try {
            db.create(database);
            System.out.println(name + '\n'+ molecule + '\n'+ database);
            db.insert(name, molecule, database);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/");
    }
}
