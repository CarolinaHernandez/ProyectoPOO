package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int numeroSilla;

	//bi-directional many-to-one association to Pasajero
	@ManyToOne
	@JoinColumn(name="PasajeroId")
	private Pasajero pasajero;

	//bi-directional many-to-one association to Itinerario
	@ManyToOne
	@JoinColumn(name="ItinerarioId")
	private Itinerario itinerario;

	public Reserva() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroSilla() {
		return this.numeroSilla;
	}

	public void setNumeroSilla(int numeroSilla) {
		this.numeroSilla = numeroSilla;
	}

	public Pasajero getPasajero() {
		return this.pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Itinerario getItinerario() {
		return this.itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

}