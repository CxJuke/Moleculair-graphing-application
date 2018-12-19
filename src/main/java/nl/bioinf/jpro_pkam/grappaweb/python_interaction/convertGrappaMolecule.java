package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

public class convertGrappaMolecule {


    public String nodes;
    public String edges;


    public void setNodes(String nodes){
    this.nodes = nodes;
    }


    public void setEdges(String arg) {
        edges = arg.replace("(", "[").replace(")", "]");

    }
}

