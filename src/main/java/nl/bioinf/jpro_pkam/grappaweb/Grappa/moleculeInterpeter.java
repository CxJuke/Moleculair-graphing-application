package nl.bioinf.jpro_pkam.grappaweb.Grappa;

/**
 * Interpeter based upon grappa.py
 * 
 * @author Jouke Profijt
 */

 public class moleculeInterpeter {
     private String inputDirectives;
     private matchGroup[] inputGroups;
     private matchGroup inputTGroup;

     public moleculeInterpeter() {
         inputDirectives = "@(),-=!";
         inputGroups[0] = new matchGroup('{', '}');
         inputGroups[1] = new matchGroup('<', '>');
         inputTGroup = new matchGroup('[', ']');
     }


 }