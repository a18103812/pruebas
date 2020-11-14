package codigo.a18103812.idat.entity;

public class Producto {
    private int id;
    private String nombre;
    private String precio;
    private String pcategoria;
    private int imagenId;

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPcategoria() {
        return pcategoria;
    }

    public void setPcategoria(String pcategoria) {
        this.pcategoria = pcategoria;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
