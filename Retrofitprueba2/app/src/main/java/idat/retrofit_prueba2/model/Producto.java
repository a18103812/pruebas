package idat.retrofit_prueba2.model;

public class Producto {
    private Long pro_codigo;
    private String pro_nombre;
    private String pro_descripcion;
    private Long pro_precio;



    public Long getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(Long pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public Long getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(Long pro_precio) {
        this.pro_precio = pro_precio;
    }
}
