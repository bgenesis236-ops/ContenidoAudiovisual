package app.model;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private String investigador;

    public Documental(String id, String titulo, String genero, int anio, String tema, String investigador) {
        super(id, titulo, genero, anio);
        this.tema = tema;
        this.investigador = investigador;
    }

    @Override
    public String toCsv() {
        return "DOCUMENTAL," + id + "," + titulo + "," + genero + "," + anio + "," + tema + "," + investigador;
    }

    public static Documental fromCsvParts(String[] p) {
        return new Documental(p[1], p[2], p[3], Integer.parseInt(p[4]), p[5], p[6]);
    }
}
