package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Pedido;
import com.tallerDeProgra.capaDeDatos.Producto;

class TestPedido {

	@Test
	void testPedido() {
		Producto producto= new Producto("papas",2,23,100);
		Pedido pedido=new Pedido(2,new Date(14/11/2022),4,producto);
		Assert.assertEquals("Error nro id",2,pedido.getId());
		Assert.assertEquals("Error en fecha", new Date(14/11/2022),pedido.getFecha());
		Assert.assertEquals("error en cantidad",4,pedido.getCantidad());
		Assert.assertEquals("error en producto",producto,pedido.getProducto());
	}

	@Test
	void testSetId() {
		Producto producto= new Producto("papas",2,23,100);
		Pedido pedido=new Pedido(2,new Date(14/11/2022),4,producto);
		pedido.setId(2);
		Assert.assertEquals("Error nro id",2,pedido.getId());
	}
	
	@Test
	void testSetFecha() {
		Producto producto= new Producto("papas",2,23,100);
		Pedido pedido=new Pedido(2,new Date(14/11/2022),4,producto);
		pedido.setFecha(new Date(4/10/2021));
		Assert.assertEquals("Error fecha",new Date(4/10/2021),pedido.getFecha());
	}
	@Test
	void testSetCantidad() {
		Producto producto= new Producto("papas",2,23,100);
		Pedido pedido=new Pedido(2,new Date(14/11/2022),4,producto);
		pedido.setCantidad(200);
		Assert.assertEquals("Error en cantidad",200,pedido.getCantidad());
	}
	@Test
	void testSetProducto() {
		Producto producto= new Producto("papas",2,23,100);
		Producto producto1= new Producto("pochoclo",5,6,50);
		Pedido pedido=new Pedido(2,new Date(14/11/2022),4,producto);
		pedido.setProducto(producto1);
		Assert.assertEquals("Error en producto",producto1,pedido.getProducto());
	}
	
}
