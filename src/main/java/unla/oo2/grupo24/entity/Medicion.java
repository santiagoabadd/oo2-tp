package unla.oo2.grupo24.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Medicion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medicion", nullable = false)
	private long idMedicion;

	@Column(name = "fecha_hora", nullable = false)
	private LocalDateTime fechaHora;

	@ManyToOne
	@JoinColumn(name = "id_dispositivo")
	Dispositivo dispositivo;

	public Medicion() {
	}

	public Medicion(LocalDateTime fechaHora, Dispositivo dispositivo) {
		this.fechaHora = fechaHora;
		this.dispositivo = dispositivo;
	}

	public long getIdMedicion() {
		return idMedicion;
	}

	public void setIdMedicion(long idMedicion) {
		this.idMedicion = idMedicion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
}
