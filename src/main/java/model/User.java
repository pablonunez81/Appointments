package model;

/**
 * Clase Abstracta, ya que nunca se instanciará la clase User.
 * La clase Abstracta es una combinación de interfaz y herencia.
 * No se implementará todos los métodos, solo los definidos como abstract
 */
public abstract class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "model.User: " + name + ", Email: " + email + 
        "\nAddress: " + address + ". Phone: " + phoneNumber;
    }

    /**
     * Obliga a implementar el comportamiento mostrar datos de usuario, 
     * que será diferente para cada implementación
     */
    public abstract void ShowDataUser();
}
