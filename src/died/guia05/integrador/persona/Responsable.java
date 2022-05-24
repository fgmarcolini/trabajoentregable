package died.guia05.integrador.persona;

import died.guia05.integrador.ubicacion.Localidad;

public class Responsable extends Persona {
	private static Integer idTotal=0;
	private String oficina;
	
	public Responsable() {
		this.id = Responsable.idTotal++;
	}
	
	public Responsable(String nombre, Localidad localidad, String oficina) {
		this();
		this.nombre = nombre;
		this.localidad = localidad;
		this.oficina = oficina;
	}

}
