package test;


import java.util.Date;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Persona;



public class TestPersona {
	
	@Test
	public void testPersona() {
		
		Date fecha = new Date(2000,6,9);
		Persona persona = new Persona("nombreYApellido",fecha);
		
		Assert.assertEquals("Error en NombreYApellido", "nombreYApellido", persona.getNombreYApellido());
		Assert.assertEquals("Error en Nacimiento", fecha, persona.getNacimiento());
		
	}
	
	@Test
	public void testSetFecha() {
		Date fecha = new Date(2000,6,9);
		Persona persona = new Persona("nombreYApellido",fecha);
		Assert.assertEquals("Error en Nacimiento", fecha, persona.getNacimiento());
	}
	
	@Test
	public void testSetPassword() {
		Date fecha = new Date(2000,6,9);
		Persona persona = new Persona("nombreYApellido",fecha);
		Assert.assertEquals("Error en NombreYApellido", "nombreYApellido", persona.getNombreYApellido());
	}
	
}
