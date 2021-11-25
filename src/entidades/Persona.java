

package entidades;

import java.io.Serializable;


public class Persona implements Serializable{
    
    private String apellido;
    private String nombre;
    private String telefonoFijo;
    private String telefonoCel;
    private String correo;

    public Persona() {
        apellido = "NA";
        nombre = "NN";
        telefonoFijo = "NF";
        telefonoCel = "NC";
        correo = "NC";
    }

    public Persona(String apellido, String nombre, String telefonoFijo, String telefonoCel, String correo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCel = telefonoCel;
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCel() {
        return telefonoCel;
    }

    public void setTelefonoCel(String telefonoCel) {
        this.telefonoCel = telefonoCel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
