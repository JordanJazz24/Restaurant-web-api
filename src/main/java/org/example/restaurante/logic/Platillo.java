package org.example.restaurante.logic;

public class Platillo {

    Categoria categoria;
    String id;
    String nombre;

    String descripcion;
    int precio;

    public Platillo() {
        categoria = new Categoria();
        id="";
        nombre="";
        descripcion="";
        precio=0;
    }

    public Platillo(Categoria categoria, String id, String nombre, String descripcion, int precio){
        this.categoria=categoria;
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Platillo clone(){
        return new Platillo(this.categoria.clone(),this.id,this.nombre,this.descripcion,this.precio);
    }
}
