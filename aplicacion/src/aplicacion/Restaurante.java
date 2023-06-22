package aplicacion;

import java.util.Arrays;
import java.util.List;


public class Restaurante implements Comparable<Restaurante> {
	
	private String nombre;
	private String direccion;
	private float precio;
	private String web;
	private String fichaGoogle;
	private float latitud;
	private float longitud;
	private String barrio;
	private List<String> especialidades;
	
	public Restaurante() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Restaurante(String nombre, String direccion, float precio, String web, String fichaGoogle, float latitud, float longitud,
			String barrio, String ... especialidades) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.precio = precio;
		this.web = web;
		this.fichaGoogle = fichaGoogle;
		this.latitud = latitud;
		this.longitud = longitud;
		this.barrio = barrio;
		this.especialidades = Arrays.asList(especialidades);
	}
	
	
	@Override
	public boolean equals (Object obj) {
		boolean iguales =  false;
		
		if (obj != null) {				
		}
			//if(obj instanceof Restaurante r = PATTERN MATCHING java 14 o 15//
			if(obj instanceof Restaurante) {
				Restaurante r = (Restaurante)obj;
					// para mi dos restaurantes son iguales
					// si tienen la misma direccion
				iguales = this.direccion.equals(r.direccion);
		}
		
		return iguales;
	}
	
	

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", direccion=" + direccion + ", precio=" + precio + ", web=" + web
				+ ", fichaGoogle=" + fichaGoogle + ", latitud=" + latitud + ", longitud=" + longitud + ", barrio="
				+ barrio + ", especialidades=" + especialidades + "]";
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getFichaGoogle() {
		return fichaGoogle;
	}
	public void setFichaGoogle(String fichaGoogle) {
		this.fichaGoogle = fichaGoogle;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public List<String> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<String> especialidades) {
		this.especialidades = especialidades;
	}


	@Override
	public int compareTo(Restaurante o) {
		int num = 0;
			if (this.precio < o.precio) {
				num = -1;
			} else if (this.precio > o.precio){
				num = 1;
			}
		return num;
	}
	
	
	

}