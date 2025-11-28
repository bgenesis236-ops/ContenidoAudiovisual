package app.repository;

import app.model.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CsvRepository implements Repository {

    private final Path path;

    public CsvRepository(String filePath) {
        this.path = Path.of(filePath);
    }

    @Override
    public List<ContenidoAudiovisual> loadAll() throws Exception {
        List<ContenidoAudiovisual> list = new ArrayList<>();

        if (!Files.exists(path)) return list;

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");

                switch (p[0]) {
                    case "PELICULA": list.add(Pelicula.fromCsvParts(p)); break;
                    case "SERIE": list.add(Serie.fromCsvParts(p)); break;
                    case "DOCUMENTAL": list.add(Documental.fromCsvParts(p)); break;
                }
            }
        }
        return list;
    }

    @Override
    public void saveAll(List<ContenidoAudiovisual> items) throws Exception {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (ContenidoAudiovisual c : items) {
                bw.write(c.toCsv());
                bw.newLine();
            }
        }
    }
}
