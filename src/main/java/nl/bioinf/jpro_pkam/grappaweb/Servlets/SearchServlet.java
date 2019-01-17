package nl.bioinf.jpro_pkam.grappaweb.Servlets;

import com.google.gson.Gson;
import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class catch the moleculename from the searchbar on the website. This molecule is saved before and can be used
 * to make other molecules.
 *
 * @author Jouke Profijt & Priscilla Kamphuis
 */
@WebServlet(name = "SearchServlet", urlPatterns = "/input.Search")
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
        String Search = request.getParameter("query");
        String database = getServletContext().getInitParameter("database");
        databaseConnector db = new databaseConnector();
        ArrayList<String> results =  db.search(Search, database);
        String json = new Gson().toJson(results);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);



    }

}
