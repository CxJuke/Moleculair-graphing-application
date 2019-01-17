package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 -----------------------
 Updated to use Jmol hex colorcodes which gives the molecules a lot more color options
 [H, {color: 'FFFFFF'}
 *
 * @author Jouke Profijt & Priscilla Kamphuis
 **/
public class convertGrappaMolecule {


    public String nodes;
    public String edges;
    public String nodeAttributes;
    //Make hashmap to put the atomnames with the right colors into it
    private HashMap<String,String> colors = new HashMap<String,String>();


    /**
     * this function fills the hashmap with the right information & makes object nodes
     * @param nodes
     */
    public void setNodes(String nodes){
        colors.put("H","#FFFFFF");
        colors.put("HE","#D9FFFF");
        colors.put("LI","#CC80FF");
        colors.put("BE","#C2FF00");
        colors.put("B","#FFB5B5");
        colors.put("C","#909090");
        colors.put("N","#3050F8");
        colors.put("O","#FF0D0D");
        colors.put("F","#90E050");
        colors.put("NE","#B3E3F5");
        colors.put("NA","#AB5CF2");
        colors.put("MG","#8AFF00");
        colors.put("AL","#BFA6A6");
        colors.put("SI","#F0C8A0");
        colors.put("P","#FF8000");
        colors.put("S","#FFFF30");
        colors.put("CL","#1FF01F");
        colors.put("AR","#80D1E3");
        colors.put("K","#8F40D4");
        colors.put("CA","#3DFF00");
        colors.put("SC","#E6E6E6");
        colors.put("TI","#BFC2C7");
        colors.put("V","#A6A6AB");
        colors.put("CR","#8A99C7");
        colors.put("MN","#9C7AC7");
        colors.put("FE","#E06633");
        colors.put("CO","#F090A0");
        colors.put("NI","#50D050");
        colors.put("CU","#C88033");
        colors.put("ZN","#7D80B0");
        colors.put("GA","#C28F8F");
        colors.put("GE","#668F8F");
        colors.put("AS","#BD80E3");
        colors.put("SE","#FFA100");
        colors.put("BR","#A62929");
        colors.put("KR","#5CB8D1");
        colors.put("RB","#702EB0");
        colors.put("SR","#00FF00");
        colors.put("Y","#94FFFF");
        colors.put("ZR","#94E0E0");
        colors.put("NB","#73C2C9");
        colors.put("MO","#54B5B5");
        colors.put("TC","#3B9E9E");
        colors.put("RU","#248F8F");
        colors.put("RH","#0A7D8C");
        colors.put("PD","#006985");
        colors.put("AG","#C0C0C0");
        colors.put("CD","#FFD98F");
        colors.put("IN","#A67573");
        colors.put("SN","#668080");
        colors.put("SB","#9E63B5");
        colors.put("TE","#D47A00");
        colors.put("I","#940094");
        colors.put("XE","#429EB0");
        colors.put("CS","#57178F");
        colors.put("BA","#00C900");
        colors.put("LA","#70D4FF");
        colors.put("CE","#FFFFC7");
        colors.put("PR","#D9FFC7");
        colors.put("ND","#C7FFC7");
        colors.put("PM","#A3FFC7");
        colors.put("SM","#8FFFC7");
        colors.put("EU","#61FFC7");
        colors.put("GD","#45FFC7");
        colors.put("TB","#30FFC7");
        colors.put("DY","#1FFFC7");
        colors.put("HO","#00FF9C");
        colors.put("ER","#00E675");
        colors.put("TM","#00D452");
        colors.put("YB","#00BF38");
        colors.put("LU","#00AB24");
        colors.put("HF","#4DC2FF");
        colors.put("TA","#4DA6FF");
        colors.put("W","#2194D6");
        colors.put("RE","#267DAB");
        colors.put("OS","#266696");
        colors.put("IR","#175487");
        colors.put("PT","#D0D0E0");
        colors.put("AU","#FFD123");
        colors.put("HG","#B8B8D0");
        colors.put("TL","#A6544D");
        colors.put("PB","#575961");
        colors.put("BI","#9E4FB5");
        colors.put("PO","#AB5C00");
        colors.put("AT","#754F45");
        colors.put("RN","#428296");
        colors.put("FR","#420066");
        colors.put("RA","#007D00");
        colors.put("AC","#70ABFA");
        colors.put("TH","#00BAFF");
        colors.put("PA","#00A1FF");
        colors.put("U","#008FFF");
        colors.put("NP","#0080FF");
        colors.put("PU","#006BFF");
        colors.put("AM","#545CF2");
        colors.put("CM","#785CE3");
        colors.put("BK","#8A4FE3");
        colors.put("CF","#A136D4");
        colors.put("ES","#B31FD4");
        colors.put("FM","#B31FBA");
        colors.put("MD","#B30DA6");
        colors.put("NO","#BD0D87");
        colors.put("LR","#C70066");
        colors.put("RF","#CC0059");
        colors.put("DB","#D1004F");
        colors.put("SG","#D90045");
        colors.put("BH","#E00038");
        colors.put("HS","#E6002E");
        colors.put("MT","#EB0026");

        this.nodes = nodes;
        this.nodes = this.assignAttributes();
    }


    /**
     * This function makes the right string for edges by replacing "()" for "[]"
     * @param arg
     */
    public void setEdges(String arg) {
        edges = arg.replace("(", "[").replace(")", "]");

    }

    /**
     * This function set the nodes
     * @param arg The nodes String
     */
    public void setNodeAttributes(String arg) {

        System.out.println(arg);
        nodeAttributes = arg;
    }

    /**
     * This function makes a new manipulated string for nodes with the right colors for each atom.
     * @return the manipulated string for nodes with the right colors for each atom
     */
    public String assignAttributes(){
        String[] seperated = this.nodes.replace("[","").replace("]","").replace("'","").split(",");
        String output = "[";
        String Attr = this.nodeAttributes;

        Pattern molecule = Pattern.compile("([A-Z])");
        Pattern index = Pattern.compile("(\\d{1,2})");
        Pattern AttributeString = Pattern.compile("\\{.+?}");
        StringBuilder attributeList = new StringBuilder();


        for (String val : seperated) {
            String ID = val.trim();
            Pattern Attributes = Pattern.compile("'(" + ID.toUpperCase() + "|" + ID.toLowerCase() + ")',\\W\\{.*?}");

            //make string for drawing tool with colors for the atoms
            Matcher moleculeMatch = molecule.matcher(val.trim());
            Matcher indexMatch = index.matcher(val.trim());
            Matcher AttributeMatch = Attributes.matcher(Attr);
            if (AttributeMatch.find()) {
                Matcher currentAttributes = AttributeString.matcher(AttributeMatch.group());
                attributeList.append("<ul class=\"list-group w-25 d-none\" id=\"").append(ID).append("\" style=\"position: absolute; right: 10px; top: 10px\">");
                attributeList.append("<li class=\"list-group-item active\">").append("Node ID: ").append(ID).append("</li>");
                if (currentAttributes.find()) {

                    String[] AttributesString = currentAttributes.group().split(";");


                    System.out.println("currentAttributes = " + currentAttributes.group());

                    for (String s : AttributesString) {
                            attributeList.append("<li class=\"list-group-item\">").append(s.replace("{", "").replace("}", "").replace("'", "")).append("</li>");
                        }
                    }
                    attributeList.append("</ul>");
                }
            String mol = ID.substring(0,1);
            System.out.println(mol);

            String mol_val = ID.substring(1);

            output += "['" + mol + mol_val + "', {color: '" + colors.get(mol)+ "'}],";




        }
        //Print the right nodes string with colors
        this.setNodeAttributes(attributeList.toString());
        return output.substring(0, output.length()-1)+ "]";

    }
}



