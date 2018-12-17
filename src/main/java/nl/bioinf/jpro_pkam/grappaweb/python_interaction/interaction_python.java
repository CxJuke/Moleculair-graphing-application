package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class interaction_python {
    public static void main(String[] args) {
        interaction_python grappa = new interaction_python();
        try {
            grappa.getOutputGrappa();
        } catch (IOException e){

        }

    }

    public void getOutputGrappa(String input) throws IOException {
        String s = null;
        try {
            Process p = Runtime.getRuntime().exec("/homes/pkamphuis/molecular_graphing-webapplication/venv/bin/python3 /homes/pkamphuis/molecular_graphing-webapplication/src/main/python/grappa.py" + input);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            System.out.println("Output grappa:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("Errors:\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
        }

        catch (IOException e) {
            System.out.println("Error message: \n");
            e.printStackTrace();
            System.exit(-1);

        }
    }
}


