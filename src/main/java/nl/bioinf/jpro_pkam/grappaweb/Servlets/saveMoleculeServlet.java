package nl.bioinf.jpro_pkam.grappaweb.Servlets;

import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "saveMoleculeServlet", urlPatterns = "/save.molecule")
public class saveMoleculeServlet extends HttpServlet {
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
