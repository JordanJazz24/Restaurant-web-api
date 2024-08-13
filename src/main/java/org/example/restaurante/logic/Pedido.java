package org.example.restaurante.logic;

public class Pedido {
    private String id;
    private String nombre;
    private int precio;
    private int quantity;
    private String size;

    public Pedido() {
    }

    public Pedido(String id, String nombre, int precio, int quantity, String size) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.quantity = quantity;
        this.size = size;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                '}';
    }
}
