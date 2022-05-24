package died.guia05.clase;

import java.time.LocalDateTime;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pasajero po1 = new Pasajero("Facundo", "Marcolini", "fgmarcolini@gmail.com", 23451);

		Pasaje p1 = new Pasaje(
				1, po1, "Paraná", "Buenos Aires", 
				LocalDateTime.of(2022, 05, 11, 12, 00), LocalDateTime.of(2022, 05, 11, 14, 00),
				22, 3000.0, TipoServicio.ECONOMY, "Aerolinea Argentina");
		
		System.out.println("Duracion del viaje: " + p1.duracion() + " hs");
		

		
	}

}
