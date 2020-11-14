package idat.edu.a18103812;

public class CategoriaItem {
    private String nombre;
    private int nroFlagImage;

    public CategoriaItem(String nombre, int nroFlagImage) {
        this.nombre = nombre;
        this.nroFlagImage = nroFlagImage;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroFlagImage() {
        return nroFlagImage;
    }

    public void setNroFlagImage(int nroFlagImage) {
        this.nroFlagImage = nroFlagImage;
    }
}