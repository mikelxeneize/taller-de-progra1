package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeDatos.Factura;
import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Pedido;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.capaDeDatos.PromocionPadre;

import junit.framework.Assert;

class TestFactura {

	@Test
	void testFactura() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",new ArrayList<PromocionPadre>());
		Assert.assertEquals("Error en id Factura",1,factura.getId());
		Assert.assertEquals("Error en la fecha",new Date(28/07/1914),factura.getFecha());
		Assert.assertEquals("Error en la mesa",mesa,factura.getMesa());
		Assert.assertEquals("Error en la pedidos",pedidos,factura.getProductos());
		Assert.assertEquals("Error en el total",(float)5000,factura.getTotal());
		Assert.assertEquals("Error en el metodo de pago","Efectivo",factura.getMetodoDePago());
		Assert.assertEquals("Error en la promociones",new ArrayList<PromocionPadre>(),factura.getPromociones());
	}
	@Test
	void testSetId() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",new ArrayList<PromocionPadre>());
		factura.setId(13);
		Assert.assertEquals("Error en id Factura",13,factura.getId());
	}
	@Test
	void testSetFecha() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",new ArrayList<PromocionPadre>());
		factura.setFecha(new Date(11/11/2011));
		Assert.assertEquals("Error en la fecha",new Date(11/11/2011),factura.getFecha());
	}
	@Test
	void testSetMesa() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		Mesa mesa1 =new Mesa(9,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",new ArrayList<PromocionPadre>());
		factura.setMesa(mesa1);
		Assert.assertEquals("Error en la mesa",mesa1,factura.getMesa());
	}

	@Test
	void testSetTotal() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Pedido pedido1=new Pedido(2,new Date(14/03/1965),3,new Producto("empanada de carne",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		Mesa mesa1 =new Mesa(9,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",new ArrayList<PromocionPadre>());
		factura.setTotal((float)666);
		Assert.assertEquals("Error en el total",(float)666,factura.getTotal());
	}
	@Test
	void testSetMetodoDePago() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Pedido pedido1=new Pedido(2,new Date(14/03/1965),3,new Producto("empanada de carne",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		Mesa mesa1 =new Mesa(9,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",new ArrayList<PromocionPadre>());
		factura.setMetodoDePago("Debito");
		Assert.assertEquals("Error en el total",("Debito"),factura.getMetodoDePago());
	}
	@Test
	void testSetPromociones() {
		Pedido pedido=new Pedido(5,new Date(14/03/1965),3,new Producto("empanada",5,10,600));
		Pedido pedido1=new Pedido(2,new Date(14/03/1965),3,new Producto("empanada de carne",5,10,600));
		Mesa mesa =new Mesa(5,"activo");
		Mesa mesa1 =new Mesa(9,"activo");
		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
		pedidos.add(pedido);
		ArrayList<PromocionPadre> promociones= new ArrayList<PromocionPadre>();
		ArrayList<PromocionPadre> promociones1= new ArrayList<PromocionPadre>();
		Comanda comanda=new Comanda(new Date(28/07/1914),new Mesa(5,"activo"),pedidos);
		Factura factura=new Factura(1,new Date(28/07/1914),mesa,pedidos,(float)5000,"Efectivo",promociones);
		factura.setPromociones(promociones1);
		Assert.assertEquals("Error en la promociones",promociones1,factura.getPromociones());
	}
}
