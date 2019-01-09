package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

 /**
* This program makes two objects: nodes and edges.
* The nodes object is a manipulated string to get colors for the atoms in the drawn molecule.
* The input is a string with nodes and the new output must be a manipulated string with colors added in this form:
* G.addNodesFrom([
    [1, {color: 'red'}],
    [2, {color: 'green'}],
    [3, {color: 'white'}]|
* Our drawing tool requires this form to give the atoms from the molecule a proper color.
* The following colors are added to each atom with this class:
* Standard colours:
    Hydrogen = White
    Oxygen = Red
    Nitrogen = Blue
    Carbon = Grey
    Sulphur = Yellow
    Phosphorus = Orange
**/

 // Imports
import java.util.HashMap;

public class convertGrappaMolecule {


    public String nodes;
    public String edges;
    //Make hashmap to put the atomnames with the right colors into it
    private HashMap<String,String> colors = new HashMap<String,String>();

    /**
     * this function fills the hashmap with the right information & makes object nodes
     * @param nodes
     */
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


    /**
     * This function makes the right string for edges by replacing "()" for "[]"
     * @param arg
     */
    public void setEdges(String arg) {
        edges = arg.replace("(", "[").replace(")", "]");

    }

    /**
     * This function makes a new manipulated string for nodes with the right colors for each atom.
     * @return the manipulated string for nodes with the right colors for each atom
     */
    public String addColour(){
        String[] seperated = this.nodes.replace("[","").replace("]","").replace("'","").split(",");
        String output = "[";
        for (String val : seperated) {

            //make string for drawing tool with colors for the atoms
            String mol = String.valueOf(val.trim().charAt(0));
            int mol_val = Integer.parseInt(val.trim().substring(1));
            output += "['" + mol+ mol_val + "', {color: '" +colors.get(mol)+"'}],";


        }
        //Print the right nodes string with colors
        System.out.println(output.substring(0,output.length()-1));
        return output.substring(0, output.length()-1)+ "]";

    }
}



