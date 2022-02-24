package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Equipo extends BaseEntity {
	
	//Añadimos las columnas, constructor, getters y setters...
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column
	private String pabellon;
	
	@Column
	private int fundado;
	
	@OneToMany
	@JoinColumn(name="equipo_id")
	List<Jugador> jugadores = new ArrayList<>();
	

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Equipo(String nombre, String ciudad, String pabellon, int fundado) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pabellon = pabellon;
		this.fundado = fundado;
	}
	
	public Equipo() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPabellon() {
		return pabellon;
	}

	public void setPabellon(String pabellon) {
		this.pabellon = pabellon;
	}

	public int getFundado() {
		return fundado;
	}

	public void setFundado(int fundado) {
		this.fundado = fundado;
	}
	
	

}
