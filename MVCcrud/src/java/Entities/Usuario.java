
package Entities;

public class Usuario {
private int id;
private String username;
private String pasword;
private String nombres;
private String apellidos;
private String email;
private String telefono;
private String cp;
private String domicilio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

   //Constructor de la clase sin parametros
    public Usuario() {
        
    }
    
    public Usuario(int id, String username, String pasword, String nombres, String apellidos, String email, String telefono, String cp, String domicilio) {
        this.id=id;
        this.username=username;
        this.pasword=pasword;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.email=email;    
        this.telefono=telefono;
        this.cp=cp;
        this.domicilio=domicilio;  
    }
}

   