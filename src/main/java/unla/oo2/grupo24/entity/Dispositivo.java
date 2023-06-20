package unla.oo2.grupo24.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dispositivo",nullable=false)
	private long id_dispositivo;
	
	@Column(name="nombre",length=60,nullable=false)
	private String nombre;
	
	@Column(name="descripcion",length=60,nullable=false)
	private String descripcion;
	
	
	@Column(name="activo",length=60,nullable=false)
	private boolean activo;
	
	@Column(name="fecha",length=60,nullable=false)
	private LocalDate fecha;
	
	@OneToMany(mappedBy="dispositivo")
	private List<Evento> eventos;
	
	@OneToMany(mappedBy="dispositivo")
	private List<Medicion> mediciones;

	public Dispositivo() {}

	public Dispositivo(String nombre, String descripcion, boolean activo, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.fecha = fecha;
	}

	public long getIdDispositivo() {
		return id_dispositivo;
	}

	public void setIdDispositivo(long idDispositivo) {
		this.id_dispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public long getId_dispositivo() {
		return id_dispositivo;
	}

	public void setId_dispositivo(long id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(List<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	
	
	
	

}