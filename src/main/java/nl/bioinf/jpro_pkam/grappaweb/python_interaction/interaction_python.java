package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class interaction_python {
    public static void main(String[] args) {
        interaction_python grappa = new interaction_python();
        try {
            grappa.getOutputGrappa("H1C1(C2(H21,H22,H23),C3(H31,H32,H33),C4(H41,H42,H43))", "/homes/jprofijt/IdeaProjects/PythonVenv/vermouth/bin/python3.5","/homes/jprofijt/IdeaProjects/molecular_graphing-webapplication/src/main/python/grappa.py" );
        } catch (IOException e){

        }

    }

    public convertGrappaMolecule getOutputGrappa(String input, String venv, String grappa) throws IOException {
        String s = null;
        int index = 0;
        convertGrappaMolecule graph = new convertGrappaMolecule();
        try {
            String command = venv + " " + grappa + " -M " + input;
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            String edges = null;
            String nodes = null;

            while ((s = stdInput.readLine()) != null) {
                if (index == 0) {
                    graph.setEdges(s);
                } else if (index == 1) {
                    graph.setNodes(s);

                }
                index += 1;


            }
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }


            System.exit(0);
        }

        catch (IOException e) {
            System.out.println("Error message: \n");
            e.printStackTrace();
            System.exit(-1);

        } return graph;
    }
}


