package died.guia05.integrador.ubicacion;

public class Provincia extends Ubicacion{
	private static Integer idTotal;
	private Pais pais;
	
	public Pais getPais() {
		return pais;
	}

	@Override
	public boolean equalsTo(Ubicacion otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Provincia otro2 = (Provincia) otro;
		if (nombre == null) {
			if (otro2.nombre != null)
				return false;
		} else if (!nombre.equals(otro2.nombre))
			return false;
		return true;
	}
	
}
