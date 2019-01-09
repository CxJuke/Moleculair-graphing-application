package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

/**
 * This class is a interaction between python and java. The grappa tool uses python and we are using java, so the output
 * of the python program must be caught in java to use it with the drawing tool to make a molecule.
 * The input is the output of the translation from the molecule with python and the output is the input in java format.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class interaction_python {


    public boolean status = true;

    /**
     *This function catch the output of the python grappa tool from the commandline in java
     * The drawing tool uses java as input
     * @param input input molecule from the user
     * @param venv
     * @param grappa path to grappa to translate input into molecule
     * @return The nodes and edges in java
     * @throws IOException when error occur
     */
    public convertGrappaMolecule getOutputGrappa(String input, String venv, String grappa) throws IOException {
        String s = null;

        int index = 0;
        convertGrappaMolecule graph = new convertGrappaMolecule();
        try {
            String[] command = {venv,
                    grappa,
                    "-M",
                    input};
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            String edges = null;
            String nodes = null;

            while ((s = stdInput.readLine()) != null) {
                if (index == 0) {
                    graph.setEdges(s.toUpperCase());
                } else if (index == 1 && !s.contains("error:")) {
                    graph.setNodes(s.toUpperCase());

                }
                else {
                    status = false;
                }
                index += 1;


            }
            //print error if something went wrong
            while ((s = stdError.readLine()) != null) {
                System.out.println("There was a problem with grappa.py. Error:");
                System.out.println(s);
            }



        }
        //print error if something went wrong
        catch (IOException e) {
            this.status = false;
            System.out.println("Error message: \n");
            e.printStackTrace();



        } return graph;

    }
}


