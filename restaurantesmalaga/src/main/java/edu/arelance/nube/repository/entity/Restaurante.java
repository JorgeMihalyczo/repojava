package edu.arelance.nube.repository.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes" )
public class Restaurante {
	
	@Id // indica que esta es la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementanble
	private Long id;
	
	private String nombre;
	
	private String direccion;
	
	private String barrio;
	
	private String web;
	
	private String fichaGoogle;
	
	private Float latitud;
	
	private Float longitud;
	
	private Integer precio;
	
	private String especialidad1;
	private String especialidad2;
	private String especialidad3;
	
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;
	
	
	// este metodo, marcado asi, se ejectua 
	// antes de insertar el restaurante
	@PrePersist 
	private void generarFechaCreacion () {
		this.creadoEn = LocalDateTime.now(); // obtengo la fecha actual
		}

	
	public Restaurante(Long id, String nombre, String direccion, String barrio, String web, String fichaGoogle,
			Float latitud, Float longitud, Integer precio, String especialidad1, String especialidad2,
			String especialidad3, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.barrio = barrio;
		this.web = web;
		this.fichaGoogle = fichaGoogle;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precio = precio;
		this.especialidad1 = especialidad1;
		this.especialidad2 = especialidad2;
		this.especialidad3 = especialidad3;
		this.creadoEn = creadoEn;
	}
	public Restaurante() {
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
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


	public Float getLatitud() {
		return latitud;
	}
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}


	public Float getLongitud() {
		return longitud;
	}
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}


	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public String getEspecialidad1() {
		return especialidad1;
	}
	public void setEspecialidad1(String especialidad1) {
		this.especialidad1 = especialidad1;
	}


	public String getEspecialidad2() {
		return especialidad2;
	}
	public void setEspecialidad2(String especialidad2) {
		this.especialidad2 = especialidad2;
	}


	public String getEspecialidad3() {
		return especialidad3;
	}
	public void setEspecialidad3(String especialidad3) {
		this.especialidad3 = especialidad3;
	}


	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}


}
