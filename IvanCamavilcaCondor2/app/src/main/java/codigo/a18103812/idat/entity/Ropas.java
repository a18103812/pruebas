package codigo.a18103812.idat.entity;

public class Ropas {
    private int id_;
    private String nombre_;
    private String precio_;
    private String pcategoria_;

    public Ropas(int id_, String nombre_, String precio_, String pcategoria_) {
        this.id_ = id_;
        this.nombre_ = nombre_;
        this.precio_ = precio_;
        this.pcategoria_ = pcategoria_;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getNombre_() {
        return nombre_;
    }

    public void setNombre_(String nombre_) {
        this.nombre_ = nombre_;
    }

    public String getPrecio_() {
        return precio_;
    }

    public void setPrecio_(String precio_) {
        this.precio_ = precio_;
    }

    public String getPcategoria_() {
        return pcategoria_;
    }

    public void setPcategoria_(String pcategoria_) {
        this.pcategoria_ = pcategoria_;
    }
}
