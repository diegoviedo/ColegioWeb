package pw2;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class nota {
	@Persistent
	String codigo,anho,curso,nota;
	
	public nota(String codigo,String anho,String curso,String nota){
		this.codigo=codigo;
		this.anho=anho;
		this.curso=curso;
		this.nota=nota;
		
	}
	
	
	public String getCodigo(){
		return codigo;
	}
	
	public String getAnho(){
		return anho;
	}
	
	public String getCurso(){
		return curso;
	}
	
	public String getNota(){
		return nota;
	}
	
	
	@Override
	public String toString() {
		String resp = codigo + "\t" + nota;  
		return resp;
	}
	
	
	
	
	
	
	
}
