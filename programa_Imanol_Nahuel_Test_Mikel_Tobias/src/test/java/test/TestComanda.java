package test;


import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Pedido;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.enums.EstadoComanda;



public class TestComanda {
	
	/**
	 * Solo se testea Comanda, por ende se asume el correcto funcionamiento de todas las clases requeridas para este testeo.
	 * 
	 * Se usan variable locales para clases no planas
	 * 
	 * nomenclatura de metodos: test + {Clase} + Desenlace: "Success" || "Error" + "_" + Variantes: Ej "2Pedidos"
	 * 
	 * 
	 */
	
	
	@Test
	public void testComanda() {
		
		Producto producto = new Producto("Fideos", 400, 800, 20);
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(new Pedido(1, new Date(), 1, producto));
		
		Mesa mesa = new Mesa(3, EstadoComanda.ABIERTA.getEstado()); 
		
		Comanda comanda = new Comanda( new Date(1,2,2022), mesa, pedidos );
		
		Assert.assertEquals("Error en id", 1, comanda.getId());
		Assert.assertEquals("Error en fecha", new Date(1,2,2022), comanda.getFecha());
		Assert.assertEquals("Error en mesa", mesa, comanda.getMesa());
		Assert.assertEquals("Error en pedidos", pedidos, comanda.getPedidos());
		
	}
	
	@Test
	public void testSetEstado() {
		Comanda comanda = new Comanda();
		comanda.setEstado("estado");
		Assert.assertEquals("Error en estado", "estado", comanda.getEstado());
	}
	
	@Test
	public void testSetFecha() {
		Comanda comanda = new Comanda();
		Date fecha = new Date(2000, 6, 9);
		comanda.setFecha(fecha);
		Assert.assertEquals("Error en estado", fecha, comanda.getFecha());
	}
	
	@Test
	public void testSetMesa() {
		Comanda comanda = new Comanda();
		Mesa mesa = new Mesa(3, "estado"); 
		comanda.setMesa(mesa);
		Assert.assertEquals("Error en estado", mesa, comanda.getMesa());
	}
	
	@Test
	public void testSetPedidos() {
		Comanda comanda = new Comanda();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		comanda.setPedidos(pedidos);
		Assert.assertEquals("Error en estado", pedidos, comanda.getPedidos());
	}
	
	
		
	
}
