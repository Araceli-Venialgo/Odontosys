package modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name= "tb_consulta")
public class ConsultaModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String motivoConsulta;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column
	private String observaciones;
	
	@Column(nullable = false)
	private double precioTotal;
	
	 // RELACION CON PACIENTE
    @ManyToOne
    @JoinColumn(name = "Paciente_id")
    private PacienteModelo paciente;

    // RELACION CON ODONTOLOGO
    @ManyToOne
    @JoinColumn(name = "Odontologo_id")
    private OdontologoModelo odontologo;
 // RELACION CON PROCEDIMIENTO
    @OneToMany(mappedBy = "consulta")
    private List<ProcedimientoModelo> procedimiento;

    // RELACION CON RECETA
    @OneToMany(mappedBy = "consulta")
    private List<RecetaModelo> receta;

	
	public ConsultaModelo() {
		super();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMotivoConsulta() {
		return motivoConsulta;
	}


	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}


	public LocalDateTime getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	}

