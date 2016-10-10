package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the itinerario database table.
 * 
 */
@Entity
@NamedQuery(name="Itinerario.findAll", query="SELECT i FROM Itinerario i")
public class Itinerario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;

	private BigInteger valor;

	//bi-directional many-to-one association to Aeronave
	@ManyToOne
	@JoinColumn(name="AeronaveId")
	private Aeronave aeronave;

	//bi-directional many-to-one association to Origendestino
	@ManyToOne
	@JoinColumn(name="DestinoId")
	private Origendestino origendestino1;

	//bi-directional many-to-one association to Origendestino
	@ManyToOne
	@JoinColumn(name="OrigenId")
	private Origendestino origendestino2;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="itinerario")
	private List<Reserva> reservas;

	public Itinerario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public BigInteger getValor() {
		return this.valor;
	}

	public void setValor(BigInteger valor) {
		this.valor = valor;
	}

	public Aeronave getAeronave() {
		return this.aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public Origendestino getOrigendestino1() {
		return this.origendestino1;
	}

	public void setOrigendestino1(Origendestino origendestino1) {
		this.origendestino1 = origendestino1;
	}

	public Origendestino getOrigendestino2() {
		return this.origendestino2;
	}

	public void setOrigendestino2(Origendestino origendestino2) {
		this.origendestino2 = origendestino2;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setItinerario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setItinerario(null);

		return reserva;
	}

}