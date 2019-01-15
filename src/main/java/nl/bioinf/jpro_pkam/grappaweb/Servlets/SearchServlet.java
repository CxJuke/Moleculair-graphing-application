package nl.bioinf.jpro_pkam.grappaweb.Servlets;

/**
 * This class catch the moleculename from the searchbar on the website. This molecule is saved before and can be used
 * to make other molecules.
 */

import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchServlet", urlPatterns = "/Search")
public class SearchServlet extends HttpServlet {
    /**
     * This function get the searchstring from the website
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Search = request.getParameter("searchstring");
        String database = getServletContext().getInitParameter("database");
        databaseConnector db = new databaseConnector();
        ArrayList<String> results =  db.search(Search, database);

        System.out.println("results = " + results);


    }

}
