package math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Constant {
    private static final HashMap<String, Double> constantMap = initConstantMap();

    private Constant() {}

    private static HashMap<String, Double> initConstantMap() {
        HashMap<String, Double> constantMap = new HashMap<>();

        try {
            BufferedReader r = new BufferedReader(new FileReader("constants.txt"));
            String line;
            String[] values;
            int counter = 1; // counter for error message

            while ((line = r.readLine()) != null) {
                values = line.split(",");

                if (values.length == 2) {
                    try {
                      constantMap.put(values[0], Double.parseDouble(values[1]));
                    }
                    catch (NumberFormatException e) {
                        System.err.println("Error: values in line " + counter + " of constant file does not match the form \"string,double\"");
                    }
                }
                else {
                    System.err.println("Error: too little or too many values in line " + counter + " of constant file");
                }

                counter++;
            }
        }
        catch (IOException e) {
            System.err.println("Error: could not read constant file");
        }

        return constantMap;
    }

    public static Double getConstantValue(String symbol) {
        return constantMap.get(symbol);
    }
}