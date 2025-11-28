package app.model;

public class Serie {
    private int numero;
    private int capitulos;

    public Serie(int numero, int capitulos) {
        this.numero = numero;
        this.capitulos = capitulos;
    }

    public Serie(String string, String title, String genero, int year) {
		// TODO Auto-generated constructor stub
	}

	public int getNumero() { return numero; }
    public int getCapitulos() { return capitulos; }

    @Override
    public String toString() {
        return "Temporada " + numero + " (" + capitulos + " capítulos)";
    }

	public static ContenidoAudiovisual fromCsvParts(String[] p) {
		// TODO Auto-generated method stub
		return null;
	}
}
