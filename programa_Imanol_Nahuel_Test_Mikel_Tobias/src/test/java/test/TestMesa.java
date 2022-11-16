package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeNegocios.Sistema;

class TestMesa {

	/**
	 * Solo se testea Mesa, por ende se asume el correcto funcionamiento de todas las clases requeridas para este testeo.
	 * 
	 * Se usan variable locales para clases no planas
	 **/
	
	@Test
	void testMesa() {
		Mesa mesa=new Mesa(3,"activo");
		Assert.assertEquals("Error en estado de la mesa", "activo",mesa.getEstado());
		Assert.assertEquals("error en cantidad de comensales",3,mesa.getCantComensales());
	}
	
	@Test
	void testSetId() {
		Mesa mesa=new Mesa(3,"activo");
		mesa.setId(5);
		Assert.assertEquals("Error en el id",5,mesa.getId());
	}
	
	@Test
	void testSetComensales() {
		Mesa mesa=new Mesa(3,"activo");
		mesa.setCantComensales(6);
		Assert.assertEquals("Error en comonesales",6,mesa.getCantComensales());
	}
	
	@Test
	void testSetEstado() {
		Mesa mesa=new Mesa(3,"activo");
		mesa.setEstado("inactivo");
		Assert.assertEquals("Error en estado de la mesa","inactivo",mesa.getEstado());
	}
	
}
