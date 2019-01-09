package nl.bioinf.jpro_pkam.grappaweb.Servlets;

import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveMoleculeServlet", urlPatterns = "/save.molecule")
public class saveMoleculeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String molecule = request.getParameter("molecule");
        String name = request.getParameter("name");
        String database = getServletContext().getInitParameter("database");
        databaseConnector db = new databaseConnector();
        db.create(database);
        db.insert(name, molecule, database);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
