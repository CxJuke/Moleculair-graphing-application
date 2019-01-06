package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

 /*
* setNodes & setEdges maakt object zodat de nodes & edges opgeslagen worden
* Hierbij moeten nog kleuren toegevoegd worden per node. Dit is de vorm die nodig is:
* G.addNodesFrom([
    [1, {color: 'red'}],
    [2, {color: 'green'}],
    [3, {color: 'white'}]
* Input is een string met allemaal nodes (object nodes, kun je gewoon gebruiken in de nieuwe functie zonder in () te zetten)
* en de output moet een nieuwe string worden met per node een kleur toegevoegd
* Standard colours:
    Hydrogen = White
    Oxygen = Red
    Nitrogen = Blue
    Carbon = Grey
    Sulphur = Yellow
    Phosphorus = Orange
  */


import java.sql.SQLOutput;
import java.util.HashMap;

public class convertGrappaMolecule {


    public String nodes;
    public String edges;
    private HashMap<String,String> colors = new HashMap<String,String>();

    public void setNodes(String nodes){
        colors.put("H","white");
        colors.put("C","grey");
        colors.put("O", "red");
        colors.put("N", "blue");
        colors.put("F", "orange");
        colors.put("S", "yellow");

        this.nodes = nodes;
        this.nodes = this.addColour();
    }





    public void setEdges(String arg) {
        edges = arg.replace("(", "[").replace(")", "]");

    }

    public String addColour(){
        String[] seperated = this.nodes.replace("[","").replace("]","").replace("'","").split(",");
        String output = "[";
        for (String val : seperated) {

            String mol = String.valueOf(val.trim().charAt(0));
            int mol_val = Integer.parseInt(val.trim().substring(1));
            output += "['" + mol+ mol_val + "', {color: '" +colors.get(mol)+"'}],";


        }
        System.out.println(output.substring(0,output.length()-1));

        return output.substring(0, output.length()-1)+ "]";

    }
}



