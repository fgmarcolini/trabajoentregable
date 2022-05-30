package died.guia05.integrador.bien;

import died.guia05.integrador.persona.Responsable;

public class Bien {
	private static Integer idTotal=0;
	private Integer id;
	private String alias;
	private String descripcion;
	private Double precio;
	private Responsable responsable;

	
	public Bien() {
		this.id = Bien.idTotal++;
	}
	
	public Bien(String alias, String descripcion, Double precio, Responsable responsable) {
		this();
		this.alias = alias;
		this.descripcion = descripcion;
		this.precio = precio;
		this.responsable = responsable;
	}

	public static Integer getIdTotal() {
		return idTotal;
	}

	public Integer getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	public Responsable getResponsable() {
		// TODO Auto-generated method stub
		return this.responsable;
	}


}
