package pw2;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class alumno {
	@Persistent
	String codigo,contrasena,nombres,apellidos,direccion,sexo,año;
	
	public alumno(){
		
	}
	
	public void setCodigo(String cod){
		codigo=cod;
	}
	
	public void setContrasena(String contra){
		contrasena=contra;
	}
	
	public void setNombres(String names){
		nombres=names;
	}
	
	public void setApellidos(String apell){
		apellidos=apell;
	}
	
	public void setDireccion(String dir){
		direccion=dir;
	}
	
	public void setSexo(String sex){
		sexo=sex;
	}
	
	public void setAño(String a){
		año=a;
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
	
	public String getAño(){
		return año;
	}
	
	@Override
	public String toString() {
		String resp = nombres + "\t" + apellidos;  
		return resp;
	}
	
	
	
	
	
	
	
}
