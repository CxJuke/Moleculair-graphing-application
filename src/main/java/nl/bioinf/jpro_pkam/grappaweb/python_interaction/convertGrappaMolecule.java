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
    Chlorine = Green
    Nitrogen = Blue
    Carbon = Grey
    Sulphur = Yellow
    Phosphorus = Orange
    Other = Varies - mostly Dark Red/Pink/Maroon
  */



public class convertGrappaMolecule {


    public String nodes;
    public String edges;


    public void setNodes(String nodes){
    this.nodes = nodes;
    }


    public void setEdges(String arg) {
        edges = arg.replace("(", "[").replace(")", "]");

    }

    public String addColour(){
        return nodes;

    }
}

