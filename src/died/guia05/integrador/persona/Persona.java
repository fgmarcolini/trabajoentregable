package died.guia05.integrador.persona;

import died.guia05.integrador.ubicacion.Localidad;

public abstract class Persona implements CriterioBusqueda<Localidad>{
	
	protected Integer id;
	protected String nombre;
	protected Localidad localidad;
	
	public Localidad getLocalidad() {
		// TODO Auto-generated method stub
		return this.localidad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	
	/*
	 * son la misma persona cuando tienen mismo nombre y id
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public Boolean esDeLocalidad(Localidad l) {
		return 
				(this.localidad.equalsTo(l) &&
				this.localidad.getProvincia().equalsTo(l.getProvincia()) &&
				this.localidad.getProvincia().getPais().equalsTo(l.getProvincia().getPais()));
				
	}
	
	public String getUbicacionTotal() {
		return this.getLocalidad().getNombre() + "," 
				+ this.getLocalidad().getProvincia().getNombre() + "," 
				+ this.getLocalidad().getProvincia().getPais().getNombre();
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
	
}
