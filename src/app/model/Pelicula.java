package app.model;

public class Pelicula extends ContenidoAudiovisual {
    private int duracionMinutos;
    private String director;

    public Pelicula(String id, String titulo, String genero, int anio, int duracionMinutos, String director) {
        super(id, titulo, genero, anio);
        this.duracionMinutos = duracionMinutos;
        this.director = director;
    }

    @Override
    public String toCsv() {
        return "PELICULA," + id + "," + titulo + "," + genero + "," + anio + "," + duracionMinutos + "," + director;
    }

    public static Pelicula fromCsvParts(String[] p) {
        return new Pelicula(
            p[1], p[2], p[3], Integer.parseInt(p[4]),
            Integer.parseInt(p[5]), p[6]);
    }
}
