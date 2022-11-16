package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeNegocios.Sistema;

class TestMozo {
	/** * Solo se testea Mozo, por ende se asume el correcto funcionamiento de todas las clases requeridas para este testeo.
	 **/
	@Test
	void testMozo() {
		Mozo mozo=new Mozo(2,"activo",10.5,"Pepe Lopez",new Date(1/12/1945));
		Assert.assertEquals("Error cantidad de hijos",2,mozo.getCantHijos());
		Assert.assertEquals("Error en estado del mozo", "activo",mozo.getEstado());
		Assert.assertEquals("error en sueldo", 10.5, mozo.getSueldo());
		Assert.assertEquals("error en nombre y apellido","Pepe Lopez",mozo.getNombreYApellido());
		Assert.assertEquals("Error en la fecha", new Date(1/12/1945),mozo.getNacimiento());
	}
	
	@Test
	void testSetCantHijos() {
		Mozo mozo=new Mozo(2,"activo",10.5,"Pepe Lopez",new Date(1/12/1945));
		mozo.setCantHijos(5);
		Assert.assertEquals("Error cantidad de hijos",5,mozo.getCantHijos());	
	}
	@Test
	void testSetEstado() {
		Mozo mozo=new Mozo(2,"activo",10.5,"Pepe Lopez",new Date(1/12/1945));
		mozo.setEstado("de Franco");
		Assert.assertEquals("Error estado","de Franco",mozo.getEstado());	
	}
	@Test
	void testSetSueldo() {
		Mozo mozo=new Mozo(2,"activo",10.5,"Pepe Lopez",new Date(1/12/1945));
		mozo.setSueldo(5000);
		Assert.assertEquals("Error sueldo",5000,mozo.getSueldo());	
	}
	@Test
	void testSetAcumulado() {
		Mozo mozo=new Mozo(2,"activo",10.5,"Pepe Lopez",new Date(1/12/1945));
		mozo.setAcumulado(5);
		Assert.assertEquals("Error cantidad de hijos",5,mozo.getAcumulado());	
	}
}

