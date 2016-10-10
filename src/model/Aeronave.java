package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aeronave database table.
 * 
 */
@Entity
@NamedQuery(name="Aeronave.findAll", query="SELECT a FROM Aeronave a")
public class Aeronave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String aerolinea;

	private int capacidad;

	private String descripcion;

	//bi-directional many-to-one association to Itinerario
	@OneToMany(mappedBy="aeronave")
	private List<Itinerario> itinerarios;

	public Aeronave() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAerolinea() {
		return this.aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Itinerario> getItinerarios() {
		return this.itinerarios;
	}

	public void setItinerarios(List<Itinerario> itinerarios) {
		this.itinerarios = itinerarios;
	}

	public Itinerario addItinerario(Itinerario itinerario) {
		getItinerarios().add(itinerario);
		itinerario.setAeronave(this);

		return itinerario;
	}

	public Itinerario removeItinerario(Itinerario itinerario) {
		getItinerarios().remove(itinerario);
		itinerario.setAeronave(null);

		return itinerario;
	}

}