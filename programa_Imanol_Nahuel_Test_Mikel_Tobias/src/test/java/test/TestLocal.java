package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Local;

class TestLocal {

	@Test
	void testLocal() {
		Local local=new Local("Pepe's pizza",(float) 542);
		Assert.assertEquals("Error Nombre","Pepe's pizza",local.getNombre());
		Assert.assertEquals("Error Sueldo",(float)542,(float)local.getSueldo());
	}
	@Test
	void testSetLocal() {
		Local local=new Local("Pepe's pizza",(float) 542);
		local.setNombre("La mini");
		Assert.assertEquals("Error Nombre","La mini",local.getNombre());
	}
	@Test
	void testSetSueldo() {
		Local local=new Local("Pepe's pizza",(float) 542);
		local.setSueldo((float) 200);
		Assert.assertEquals("Error Sueldo",(float)200,(float)local.getSueldo());
	}

}
