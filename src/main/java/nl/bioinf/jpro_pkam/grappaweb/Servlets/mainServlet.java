package nl.bioinf.jpro_pkam.grappaweb.Servlets;

/**
 *
 */

import nl.bioinf.jpro_pkam.grappaweb.python_interaction.convertGrappaMolecule;
import nl.bioinf.jpro_pkam.grappaweb.python_interaction.interaction_python;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mainServlet", urlPatterns = "/graph.draw")
public class mainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String molecule = request.getParameter("molecule");
        String pythonVenv = getServletContext().getInitParameter("pythonVenv");
        String grappa = getServletContext().getInitParameter("grappa.path");
        interaction_python grapher = new interaction_python();
        convertGrappaMolecule graph = grapher.getOutputGrappa(molecule, pythonVenv, grappa);
            request.setAttribute("error", grapher.status);
            request.setAttribute("nodes", graph.nodes);
            request.setAttribute("edges", graph.edges);
            request.setAttribute("mol_old", molecule);

            RequestDispatcher view = request.getRequestDispatcher("graph.jsp");
            view.forward(request, response);
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
