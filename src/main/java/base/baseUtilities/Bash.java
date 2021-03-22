package base.baseUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bash {

    public static ArrayList<String> command(final String cmdline, final String directory) {
        try {
            Process process = new ProcessBuilder("bash", "-c", cmdline)
                            .redirectErrorStream(true)
                            .directory(new File(directory))
                            .start();

            ArrayList<String> output = new ArrayList<>();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null)
                output.add(line);

            if (0 != process.waitFor())
                return null;

            return output;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}