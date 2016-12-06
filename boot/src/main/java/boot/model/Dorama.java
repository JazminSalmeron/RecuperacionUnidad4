package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="dorama")
public class Dorama implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dorama_id")
	private int doramaID;
	@Column(length=20, name="nombre")
	private String nombre;
	@Column(length=20, name="produccion")
	private String produccion;
	@Column(length=20, name="descripcion")
	private String descripcion;

	
	public Dorama(String nombre, String produccion,String descripcion){
		super();
		this.nombre = nombre;
		this.produccion = produccion;
		this.descripcion = descripcion;
		
	}
	
	public Dorama(){
		this("", "", "");
	}
	
	

	public int getDoramaID() {
		return doramaID;
	}

	public void setDoramaID(int doramaID) {
		this.doramaID = doramaID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProduccion() {
		return produccion;
	}

	public void setProduccion(String produccion) {
		this.produccion = produccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Dorama [doramaID=" + doramaID + ", nombre=" + nombre + ", produccion=" + produccion + ", descripcion="
				+ descripcion + "]";
	}

	
}
