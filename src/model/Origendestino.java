package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the origendestino database table.
 * 
 */
@Entity
@NamedQuery(name="Origendestino.findAll", query="SELECT o FROM Origendestino o")
public class Origendestino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Itinerario
	@OneToMany(mappedBy="origendestino1")
	private List<Itinerario> itinerarios1;

	//bi-directional many-to-one association to Itinerario
	@OneToMany(mappedBy="origendestino2")
	private List<Itinerario> itinerarios2;

	public Origendestino() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Itinerario> getItinerarios1() {
		return this.itinerarios1;
	}

	public void setItinerarios1(List<Itinerario> itinerarios1) {
		this.itinerarios1 = itinerarios1;
	}

	public Itinerario addItinerarios1(Itinerario itinerarios1) {
		getItinerarios1().add(itinerarios1);
		itinerarios1.setOrigendestino1(this);

		return itinerarios1;
	}

	public Itinerario removeItinerarios1(Itinerario itinerarios1) {
		getItinerarios1().remove(itinerarios1);
		itinerarios1.setOrigendestino1(null);

		return itinerarios1;
	}

	public List<Itinerario> getItinerarios2() {
		return this.itinerarios2;
	}

	public void setItinerarios2(List<Itinerario> itinerarios2) {
		this.itinerarios2 = itinerarios2;
	}

	public Itinerario addItinerarios2(Itinerario itinerarios2) {
		getItinerarios2().add(itinerarios2);
		itinerarios2.setOrigendestino2(this);

		return itinerarios2;
	}

	public Itinerario removeItinerarios2(Itinerario itinerarios2) {
		getItinerarios2().remove(itinerarios2);
		itinerarios2.setOrigendestino2(null);

		return itinerarios2;
	}

}