package modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
	@Entity(name = "tb_agendamiento")
	public class AgendamientoModelo {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column(nullable = false)
	private String descripcion;
	
	// RELACION CON PACIENTE
    @ManyToOne 
    @JoinColumn(name = "Paciente_id")
    private PacienteModelo paciente;

    // RELACION CON ODONTOLOGO
    @ManyToOne
    @JoinColumn(name = "Odontologo_id")
    private OdontologoModelo odontologo;

	
	
	public AgendamientoModelo() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 }
