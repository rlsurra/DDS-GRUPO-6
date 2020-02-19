package ar.edu.utn.frba.dds.csvReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Ciudad> readBooksFromCSV(String fileName) {
        List<Ciudad> ciudades = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.UTF_8)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                String[] attributes = line.split(",");

                try {
                    Ciudad ciudad = crearCiudad(attributes);
                    ciudades.add(ciudad);
                    line = br.readLine();
                } catch (Exception e) {
                    line = br.readLine();
                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return ciudades;
    }

    private static Ciudad crearCiudad(String[] metadata) {
        String name = metadata[1];
        String s = metadata[0];
        String stringId = s.trim();
        int id = Integer.parseInt(stringId);
        return new Ciudad(name, id);
    }

}
