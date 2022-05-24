package died.guia05.integrador.persona;

import died.guia05.integrador.ubicacion.Localidad;

public interface CriterioBusqueda<T> {
	
	public Boolean esDeLocalidad(Localidad l);

}
