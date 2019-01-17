package nl.bioinf.jpro_pkam.grappaweb.Servlets;

import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class gives the molecule sequence if
 * something is selected in the database.
 *
 * @author Jouke Profijt & Priscilla Kamphuis
 */
@WebServlet(name = "getMoleculeServlet", urlPatterns = "/get.molecule")
public class getMoleculeServlet extends HttpServlet {

    /**
     * This function gives the molecule sequence in the input bar if something is selected in the database with search.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moleculeName = request.getParameter("moleculeName");
        String database = getServletContext().getInitParameter("database");
        databaseConnector db = new databaseConnector();
        String molecule =  db.getMolecule(moleculeName, database);

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(molecule);

    }
}
