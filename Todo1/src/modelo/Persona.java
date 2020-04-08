/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Persona {
    protected String id; 
    protected String sexo;
    protected String nombre;
    protected String direccion;
    protected int edad;
    protected String ciudad;
    protected String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public Persona(String id, String sexo, String nombre, String direccion, int edad, String ciudad, String telefono) {
        this.id = id;
        this.sexo = sexo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.ciudad = ciudad;
        this.telefono=telefono;
    }
    

	public String getDocumento() {
        return id;
    }

    public void setDocumento(String id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombre) {
        this.nombre = nombre;
    }
  
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}
