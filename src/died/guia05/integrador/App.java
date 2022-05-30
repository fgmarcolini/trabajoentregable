package died.guia05.integrador;

import died.guia05.integrador.persona.*;
import died.guia05.integrador.ubicacion.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import died.guia05.integrador.bien.*;

// Clase de prueba para validar los requerimientos
// del ejercicio integrador

public class App {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  
	  
	  Pais arg = new Pais("Argentina");
	  Pais chi = new Pais("Chile");
	  
	  Provincia entreRios = new Provincia("Entre Rios", arg);
	  Provincia santaFe = new Provincia("Santa Fe", arg);
	  Provincia santiago = new Provincia("Santiago", chi);

	  Localidad parana = new Localidad("Paraná", entreRios);
	  Localidad diamante = new Localidad("Diamante", entreRios);
	  Localidad santaFeCapital = new Localidad("Santa Fe", santaFe);
	  Localidad santiagoCapital = new Localidad("Santiago de Chile", santiago);
	  
	  
	  Proveedor pdor1 = new Proveedor("Facundo", parana);
	  
	  // Proveedor y Responsable de misma localidad
	  Responsable resp1 = new Responsable("Lautaro", parana, "Departamento de Gestion");
	  
	  // Responsable de mismo pais y provincia pero distinta localidad que pdor1
	  Responsable resp2 = new Responsable("Nicolas", diamante, "Departamento de Programación");
	  
	  // Responsable de mismo pais pero distinta provincia y localidad que pdor1
	  Responsable resp3 = new Responsable("German", santaFeCapital, "Departamento de Analisis");
	  
	  // Responsable de distinto pais que pdor1
	  Responsable resp4 = new Responsable("Julian", santiagoCapital, "Departamento de Recursos Humanos");
	  
	  // Creación de bienes de pdor1
	  Bien tel = new Bien("Samsung Galaxy A52", "Telefono samsung de ultima generacion", 500.0, resp1);
	  Bien note = new Bien("Notebook i3 7ma generación", "Notebook con un i3 de 7ma generaición", 500.0, resp2);
	  Bien tablet = new Bien("Tablet Microsoft ", "Una tabla de la marca Microsoft de 7 pulgadas", 2500.0, resp3);
	  Bien ereader = new Bien("EReader Kindle", "EReader Kindle de Amazon de ultima generacion", 2700.0, resp4);
	  
	  pdor1.asignarBienes(new ArrayList<Bien>(Arrays.asList(tel,note,tablet,ereader)));
	  
	  
	  // Creación de facturas
	  ArrayList<Bien> listaAux = new ArrayList<Bien>(Arrays.asList(tel,note)); 	// Lista auxiliar de bienes, monto total base = $1000.0
	  
	  // Factura con -> Proveedor y Responsable de misma localidad
	  Factura f1 = new Factura(new ArrayList<Bien>(listaAux), new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp1, pdor1);
	  
	  // Factura con -> Responsable de mismo pais y provincia pero distinta localidad que pdor1
	  Factura f2 = new Factura(new ArrayList<Bien>(listaAux), new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp2, pdor1);
	  
	  // Factura con -> Responsable de mismo pais pero distinta provincia y localidad que pdor1
	  Factura f3 = new Factura(new ArrayList<Bien>(listaAux), new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp3, pdor1);
	  
	  // Factura con -> Responsable de distinto pais que pdor1
	  Factura f4 = new Factura(new ArrayList<Bien>(listaAux), new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp4, pdor1);
	  
	  ArrayList<Factura> facturasOutput = new ArrayList<Factura>(Arrays.asList(f1,f2,f3,f4));	// Lista auxiliar para mostrar datos
	  for(Factura x : facturasOutput) {
		  System.out.println("Factura " + x.getId() 
		  			+ " Proveedor: " + x.getProveedor().getNombre() 
		  			+ "[" + x.getProveedor().getUbicacionTotal()
		  			+ "] Responsable: " + x.getResponsable().getNombre()
		  			+ "[" + x.getResponsable().getUbicacionTotal()
		  			+ "] = $" + x.getMontoTotal());
	  }
	  // pd: Se asume que si no se puede realizar el envio, el monto es 0.
	  
	  separador();
	  
	  // Se agregara el mismo bien a la listaAux con el fin de comprobar los requerimientos del problema
	  // Se quieren facturar 6 bienes
	  // 500*6*1.10 - (500*6*1.10)*0.10
	  for(int i = 0; i < 4; i++) 
		  listaAux.add(tel);
	  
	  Factura fMayor5 = new Factura(new ArrayList<Bien>(listaAux), new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp1, pdor1);
	  System.out.println("Factura " + fMayor5.getId() + "[10>Bienes>5]"
				+ " Proveedor: " + pdor1.getNombre() 
				+ "[" + pdor1.getUbicacionTotal()
				+ "] Responsable: " + resp1.getNombre()
				+ "[" + resp1.getUbicacionTotal()
				+ "] = $" + fMayor5.getMontoTotal());
	  
	  // Se quieren facturar 11 bienes
	  // 500*11*1.10 - (500*11*1.10)*0.20
	  for(int i = 0; i < 5; i++) 
		  listaAux.add(tel);
	  
	  Factura fMayor10 = new Factura(new ArrayList<Bien>(listaAux), new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp1, pdor1);
	  System.out.println("Factura " + fMayor10.getId() + "[20>Bienes>10]"
				+ " Proveedor: " + pdor1.getNombre() 
				+ "[" + pdor1.getUbicacionTotal()
				+ "] Responsable: " + resp1.getNombre()
				+ "[" + resp1.getUbicacionTotal()
				+ "] = $" + fMayor10.getMontoTotal());
	  
	  // Si se quieren facturar más de 20 bienes
	  ArrayList<Bien> listaAux2 = new ArrayList<Bien>(listaAux);
	  for(int i = 0; i < 10; i++) 
		  listaAux2.add(tel);
	  Factura fMayor20 = new Factura(listaAux2, new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp1, pdor1);
	  
	  
	  separador();

	  if(pdor1.esDeLocalidad(parana))
		  System.out.println( pdor1.getNombre() + " es de " + parana.getNombre());
	  else
		  System.out.println( pdor1.getNombre() + " NO es de " + parana.getNombre());
	  
	  separador();
	  
	  // CREACIÓN DE EMPRESA
	  Empresa e1 = new Empresa();
	  
	  Proveedor pdor2 = new Proveedor("Juan", diamante);
	  Factura f6 = new Factura(listaAux, new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), resp1, pdor2);
	  facturasOutput.addAll(Arrays.asList(fMayor5, fMayor10, f6));
	  e1.setFacturas(facturasOutput);
	  e1.setProveedores(new ArrayList<Proveedor>(Arrays.asList(pdor1, pdor2)));
	  e1.setResponsables(new ArrayList<Responsable>(Arrays.asList(resp1,resp2,resp3,resp4)));
	  e1.setBienes(new ArrayList<Bien>(Arrays.asList(tel,note,tablet,ereader)));
	  
	  System.out.println("Facturas Totales:");
	  e1.getFacturas()
			  .stream()
			  .forEach(x -> System.out.println("Factura " + x.getId() 
				  + " Proveedor: " + x.getProveedor().getNombre() 
				  + " Responsable: " + x.getResponsable().getNombre()));
	  
	  System.out.println("\nFacturas Totales de Proveedor " + pdor1.getNombre());
	  e1.listarFacturaByProveedor(pdor1).stream().forEach(x -> System.out.println("Factura " + x.getId()));
	  
	  System.out.println("\nFacturas Totales de Proveedor " + pdor2.getNombre());
	  e1.listarFacturaByProveedor(pdor2).stream().forEach(x -> System.out.println("Factura " + x.getId()));
	  
	  separador();
	  
	  System.out.println("\nFacturas Totales de Responsable " + resp1.getNombre());
	  e1.listarFacturaByResponsable(resp1).stream().forEach(x -> System.out.println("Factura " + x.getId()));
	  
	  System.out.println("\nFacturas Totales de Responsable " + resp2.getNombre());
	  e1.listarFacturaByResponsable(resp2).stream().forEach(x -> System.out.println("Factura " + x.getId()));
	  
	  separador();
	  
	  System.out.println("\nProveedores de " + parana.getNombre());
	  e1.listarNombresProveedores(parana).stream().forEach(x -> System.out.println(x));
	  
	  System.out.println("\nProveedores de " + diamante.getNombre());
	  e1.listarNombresProveedores(diamante).stream().forEach(x -> System.out.println(x));
	  
	  separador();

	  System.out.println("\nBienes solicitados por personas de " + parana.getNombre());
	  e1.listarBienesByLocalidad(parana).stream().forEach(x -> System.out.println(x.getAlias()));
	  
	  separador();
	  
	  System.out.println("\nBienes con un precio mayor a $500.00 ");
	  e1.listarBienesByPrecioMayor(500.00).stream().forEach(x -> System.out.println(x.getAlias()));
	  
	  separador();
	  
	  System.out.println("\nFacturas con un monto mayor a $2000.00 ");
	  e1.listarFacturasByMontoMayor(2000.00).stream().forEach(x -> System.out.println("Factura " + x.getId()));
	  
	  separador();
	  
	  System.out.println("\nFacturas hechas por proveedor " + pdor1.getNombre());
	  e1.listarFactuadasPorProveedor(pdor1).stream().forEach(x -> System.out.println(x));
	  
	  System.out.println("\nFacturas hechas por proveedor " + pdor2.getNombre());
	  e1.listarFactuadasPorProveedor(pdor2).stream().forEach(x -> System.out.println(x));

  }
  
  public static void separador() {
	  System.out.println("\n-------------------------------------");
  }

}
