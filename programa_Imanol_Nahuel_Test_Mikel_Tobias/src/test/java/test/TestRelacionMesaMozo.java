package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.capaDeDatos.RelacionMesaMozo;

class TestRelacionMesaMozo {

	@Test
	void testMesaMozo() {
		Mesa mesa= new Mesa(4,"activo");
		Mozo mozo= new Mozo(2,"de Franco",100,"Pepe Perez", new Date(9/07/1816));
		RelacionMesaMozo relacionMesaMozo=new RelacionMesaMozo(mesa,mozo);
		Assert.assertEquals("Error mesa",mesa,relacionMesaMozo.getMesa());
		Assert.assertEquals("Error mozo",mozo,relacionMesaMozo.getMozo());
	}
	@Test
	void testSetMesa() {
		Mesa mesa= new Mesa(4,"activo");
		Mozo mozo= new Mozo(2,"de Franco",100,"Pepe Perez", new Date(9/07/1816));
		Mesa mesa1= new Mesa(6,"activo");
		RelacionMesaMozo relacionMesaMozo=new RelacionMesaMozo(mesa,mozo);
		relacionMesaMozo.setMesa(mesa1);
		Assert.assertEquals("Error mesa",mesa1,relacionMesaMozo.getMesa());
	}
	@Test
	void testSetMozo() {
		Mesa mesa= new Mesa(4,"activo");
		Mozo mozo= new Mozo(2,"de Franco",100,"Pepe Perez", new Date(9/07/1916));
		RelacionMesaMozo relacionMesaMozo=new RelacionMesaMozo(mesa,mozo);
		Mozo mozo1= new Mozo(3,"Ausente",188,"Pep Guardiola", new Date(25/05/1810));
		relacionMesaMozo.setMozo(mozo1);
		Assert.assertEquals("Error mozo",mozo1,relacionMesaMozo.getMozo());
	}
	
	
}

