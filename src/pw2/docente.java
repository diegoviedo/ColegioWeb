package pw2;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class docente {
	@Persistent
	String codigo,contrasena,nombres,apellidos,direccion,sexo,tutorAnho,curso,correo,telefono;
	
	public docente(String codigo,String contrasena,String nombres,String apellidos,String direccion,String sexo,String tutorAnho,String curso,String correo,String telefono){
		this.codigo=codigo;
		this.contrasena=contrasena;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.tutorAnho=tutorAnho;
		this.curso=curso;
		this.correo=correo;
		this.telefono=telefono;
	}
	
	
	public String getCodigo(){
		return codigo;
	}
	
	public String getContrasena(){
		return contrasena;
	}
	
	public String getNombres(){
		return nombres;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	public String getTutorAnho(){
		return tutorAnho;
	}
	
	public String getCurso(){
		return curso;
	}
	
	public String getCorreo(){
		return correo;
	}
	
	public String getTelefono(){
		return telefono;
	}
	
	
	
	@Override
	public String toString() {
		String resp = nombres + "\t" + apellidos;  
		return resp;
	}
	
	
	
	
	
	
	
}
