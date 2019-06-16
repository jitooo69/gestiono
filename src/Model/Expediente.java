package Model;

import java.sql.Date;

public class Expediente {
	String codigo, asunto, descripcion;
	Usuario responsable;
	Departamento departamento;
	Date fecha;
	
	public Expediente (String codigo, String asunto, String descripcion,
						Usuario responsable, Departamento departamento, Date fecha) {
		this.codigo = codigo;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.responsable = responsable;
		this.departamento = departamento;
		this.fecha = fecha;

	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Usuario getResponsable() {
		return responsable;
	}
	
	public void setFuncionario(Usuario nuevoFuncionario) {
		this.responsable = nuevoFuncionario;
	}
}
