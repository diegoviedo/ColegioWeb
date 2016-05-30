package pw2;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class comunicado {
	@Persistent
	String comunicado,fecha;
	
	public comunicado(String comunicado,String fecha){
		this.comunicado=comunicado;
		this.fecha=fecha;
		
	}
	
	public String getComunicado(){
		return comunicado;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String resp = comunicado + "\n "+ "PUBLICADO EL "+ fecha;  
		return resp;
	}
	
	
	
	
	
	
	
}
