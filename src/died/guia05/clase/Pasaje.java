package died.guia05.clase;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;


/*
 * 1. Clase Pasaje
 */
public class Pasaje {
	
	// variable de clase para definir codigos
	private static Integer codigos = 0;

	private Integer codPasaje;
	private Integer numVuelo;
	private String origen;
	private String destino;
	private LocalDateTime tiempoPartida;
	private LocalDateTime tiempoArribo;
	private LocalDateTime tiempoMaximoCancelacion;	// debe ser anterior por 24hs al tiempoPartida
	private Integer asiento;
	private Double monto;
	private TipoServicio servicio;
	private String aerolinea;
	
	@Override
	public String toString() {
		return "Pasaje [codPasaje=" + codPasaje + ", numVuelo=" + numVuelo + ", origen=" + origen + ", destino="
				+ destino + ", tiempoPartida=" + tiempoPartida + ", tiempoArribo=" + tiempoArribo
				+ ", tiempoMaximoCancelacion=" + tiempoMaximoCancelacion + ", asiento=" + asiento + ", monto=" + monto
				+ ", servicio=" + servicio + ", aerolinea=" + aerolinea + ", pasajero=" + pasajero + "]";
	}

	public Pasajero pasajero;
	
	public Pasaje(Integer numVuelo, Pasajero pasajero, String origen, String destino, 
			LocalDateTime tiempoPartida,LocalDateTime tiempoArribo, Integer asiento, Double monto, 
			TipoServicio servicio, String aerolinea) {
		
		
		super();
		this.codPasaje = Pasaje.codigos++;
		this.pasajero = pasajero;
		this.numVuelo = numVuelo;
		this.origen = origen;
		this.destino = destino;
		this.tiempoPartida = tiempoPartida;
		this.tiempoArribo = tiempoArribo;
		this.tiempoMaximoCancelacion = tiempoPartida.minusDays(1);
		this.asiento = asiento;
		this.monto = monto;
		this.servicio = servicio;
		this.aerolinea = aerolinea;
		
	}

/*
 * 2. método equals
 */
	@Override
	public int hashCode() {
		return Objects.hash(codPasaje, destino, origen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasaje other = (Pasaje) obj;
		return Objects.equals(codPasaje, other.codPasaje) && Objects.equals(destino, other.destino)
				&& Objects.equals(origen, other.origen);
	}
	
/*
 * 3. Agregar al pasaje el método “duración” que retorna la duración del viaje
 */

	public Long duracion() {
		
		// Retorna la duración del viaje en HORAS.
		return (Duration.between(tiempoPartida, tiempoArribo).getSeconds())/60/60;
	}
	
}
