package com.tallerDeProgra.capaDePresentacion.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Vistas.IVista;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaAsignarEstadoMozo;
import com.tallerDeProgra.capaDePresentacion.Vistas.VistaFacturacionYPedidos;
import com.tallerDeProgra.enums.EstadoComanda;

public class ControladorFacturacionYPedidos implements ActionListener{
	private VistaFacturacionYPedidos vista = null;
	private Sistema modelo;
	private int tipoOperario;
	
	
	public ControladorFacturacionYPedidos(int tipoOperario) {
		this.vista = new VistaFacturacionYPedidos();
		this.modelo = Sistema.getInstance();
		this.vista.addActionListener(this);
		this.vista.actualizaComboBoxComandas(modelo.getComandas());
		this.tipoOperario = tipoOperario;
		if(modelo.getComandas().isEmpty()) {
			this.vista.habilitarCerrarComanda(false);
			this.vista.habilitarPedido(false);
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.MODIFICACION_LISTA_PRODUCTOS)) {
			
		}
		if(e.getActionCommand().equals(IVista.CREAR_COMANDA)) {
			ControladorAltaComanda controladorAltacom= new ControladorAltaComanda(tipoOperario);
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.CERRAR_COMANDA)) {
			ControladorCerrarComanda controladorComanda= new ControladorCerrarComanda(tipoOperario,this.vista.getComanda());
			
		}
		if(e.getActionCommand().equals(IVista.AGREGAR_PEDIDO)) {
			ControladorAltaPedido controladorAltaPedido= new ControladorAltaPedido(tipoOperario, this.vista.getComanda(),false);	
			this.vista.cerrar();
		}
		if(e.getActionCommand().equals(IVista.ATRAS_COMANDA)) {
			ControladorMenuOperarioAdministrador controladorMenu = new ControladorMenuOperarioAdministrador(tipoOperario); 
			this.vista.cerrar();		
		}
	}
}
