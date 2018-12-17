package nl.bioinf.jpro_pkam.grappaweb.python_interaction;

import java.io.IOException;

public class interaction_python {
    //public void main(String[] args) {
      //  System.out.println(this.getOutputGrappa());
    //}

    public String getOutputGrappa() throws IOException {
        Process p = Runtime.getRuntime().exec("pythonVenv ../../../../../../python/grappa.py");

        return p.getOutputStream().toString();
    }
}


