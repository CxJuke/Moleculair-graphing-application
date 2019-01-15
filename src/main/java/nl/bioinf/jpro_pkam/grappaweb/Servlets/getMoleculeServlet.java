package nl.bioinf.jpro_pkam.grappaweb.Servlets;

import com.google.gson.Gson;
import nl.bioinf.jpro_pkam.grappaweb.Database.databaseConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getMoleculeServlet", urlPatterns = "/get.molecule")
public class getMoleculeServlet extends HttpServlet {

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
