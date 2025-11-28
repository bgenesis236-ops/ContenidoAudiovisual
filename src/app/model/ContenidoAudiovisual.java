package app.model;

public abstract class ContenidoAudiovisual {
    protected String id;
    protected String titulo;
    protected String genero;
    protected int anio;

    public ContenidoAudiovisual(String id, String titulo, String genero, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }

    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " (" + anio + ") - " + genero;
    }

    public abstract String toCsv();
}
