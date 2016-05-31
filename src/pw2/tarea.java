package pw2;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class tarea {
	@Persistent
	String nombre,tutorAnho,curso,dia,mes,hora,minuto,tarea,fecha;
	
	public tarea(String nombre,String tutorAnho,String curso,String dia,String mes,String hora,String minuto,String tarea,String fecha){
		this.nombre=nombre;
		this.tutorAnho=tutorAnho;
		this.curso=curso;
		this.dia=dia;
		this.mes=mes;
		this.hora=hora;
		this.minuto=minuto;
		this.tarea=tarea;
		this.fecha=fecha;
	}

	public String getFecha(){
		return fecha;
	}

	public String getNombre(){
		return nombre;
	}
	
	public String getTutorAnho(){
		return tutorAnho;
	}
	
	public String getCurso(){
		return curso;
	}
	
	public String getDia(){
		return dia;
	}
	
	public String getMes(){
		return mes;
	}
	
	public String getHora(){
		return hora;
	}
	
	public String getMinuto(){
		return minuto;
	}
	
	public String getTarea(){
		return tarea;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String resp = nombre + "\t" + dia;  
		return resp;
	}
	
	
	
	
	
	
	
}
