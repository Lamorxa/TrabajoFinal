package VideoPanel;

public class Name {
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRutaVideo() {
        return rutaVideo;
    }

    public void setRutaVideo(String rutaVideo) {
        this.rutaVideo = rutaVideo;
    }

    private String rutaVideo;

    public Name(String titulo, String rutaVideo) {
        this.titulo = titulo;
        this.rutaVideo = rutaVideo;
    }
}
