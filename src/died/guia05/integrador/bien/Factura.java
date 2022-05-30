package died.guia05.integrador.bien;

import java.util.ArrayList;
import java.util.Date;

import died.guia05.integrador.persona.Proveedor;
import died.guia05.integrador.persona.Responsable;
import died.guia05.integrador.ubicacion.Localidad;
import died.guia05.integrador.ubicacion.Pais;
import died.guia05.integrador.ubicacion.Provincia;
import died.guia05.integrador.ubicacion.errores.DistintoPaisException;
import died.guia05.integrador.ubicacion.errores.ExcesoBienException;

public class Factura implements Comparable<Factura>{
	private static Integer idTotal=0;
	private Integer id;
	private Double montoTotal = 0.0;
	private ArrayList<Bien> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private Date fecha;

	public Factura() {
		id = Factura.idTotal++;
		bienes = new ArrayList<Bien>();
	}
	
	public Factura(ArrayList<Bien> bienes, Date fecha ,Responsable responsable, Proveedor proveedor) {
		this();
		this.bienes = bienes;
		this.fecha = fecha;
		this.responsable = responsable;
		this.proveedor = proveedor;
		
		this.montoTotal = this.calculaMontoTotal();
	}
	
	public Integer getId() {
		return id;
	}

	private double calculaMontoTotal(){
		Double montoAux = 0.0;
		
		for (Bien bien : this.bienes) {
			montoAux += bien.getPrecio();
		}
		
		try {
			// se le aplican los impuestos de distancias (pais, provincia, localidad)
			montoAux = this.aplicaImpuestoDistancia(montoAux);
			montoAux = this.aplicaDescuento(montoAux);
		
		}
		catch(DistintoPaisException e) {
			e.printStackTrace();
			montoAux=0.0; 		// Se asume que si no se puede realizar el envio, el monto es 0.
		}
		catch(ExcesoBienException e) {
			e.printStackTrace();
		}
		
		
		return montoAux;
	}

	private Double aplicaImpuestoDistancia(Double monto) throws DistintoPaisException {
		
		Localidad locProveedor = this.proveedor.getLocalidad();
		Localidad locResponsable = this.responsable.getLocalidad();
		
		Provincia provProveedor = locProveedor.getProvincia();
		Provincia provResponsable = locResponsable.getProvincia();
		
		Pais paisProveedor = provProveedor.getPais();
		Pais paisResponsable = provResponsable.getPais();
		
		// distinto pais
		if(!paisProveedor.equals(paisResponsable)) {
			throw new DistintoPaisException("ERROR! El responsable y el proveedor viven en distintos paises.");
		}
		
		// mismo pais, misma provincia, misma localidad
		else if(paisProveedor.equalsTo(paisResponsable) &&
				provProveedor.equalsTo(provResponsable) &&
				locProveedor.equalsTo(locResponsable)) {
			monto *= 1.10;
		}
		
		// mismo pais, misma provincia, distinta localidad
		else if(paisProveedor.equalsTo(paisResponsable) &&
				provProveedor.equalsTo(provResponsable) &&
				!locProveedor.equalsTo(locResponsable)) {
			monto *= 1.30;
		}
		
		// mismo pais, distinta provincia, distinta localidad
		else {
			monto *= 1.70;
		}
		
		return monto;
	}
	
	private Double aplicaDescuento(Double monto) throws ExcesoBienException {
		
		// ninguna factura debe permitirse m�s de 20 bienes
		if(bienes.size() > 20) {
			throw new ExcesoBienException("ERROR! Una factura no puede cargarse con más de 20 bienes");
		}
		
		else if(bienes.size() > 10) {
			monto -= (monto*0.20);
		}
		
		else if(bienes.size() > 5) {
			monto -= (monto*0.10);
		}
		
		return monto;
	}

	public Proveedor getProveedor() {
		// TODO Auto-generated method stub
		return this.proveedor;
	}

	public Responsable getResponsable() {
		// TODO Auto-generated method stub
		return this.responsable;
	}

	public Double getMontoTotal() {
		// TODO Auto-generated method stub
		return this.montoTotal;
	}

	public int compareTo(Factura f2) {
		// esto permitira ordenar de manera descendente por fecha
		return f2.getFecha().compareTo(this.fecha);
	}

	public Date getFecha() {
		// TODO Auto-generated method stub
		return this.fecha;
	}

	public ArrayList<Bien> getBienes() {
		// TODO Auto-generated method stub
		return this.bienes;
	}

}
