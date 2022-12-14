package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeNegocios.Local;

import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class VentanaPromocionTemporalNuevo extends JFrame implements IVista {
	private JButton btnCreacion;
	private JButton btnVolver;
	private JPanel panelCreacion;
	private JPanel panel2;
	private JLabel lblNombre;
	private JLabel lblDiaSemana;
	private JLabel lblPorcentaje;
	private JLabel lblEstado;
	private JButton btnEstadoActivo;
	private JButton btnEstadoInactivo;
	
	


	private JPanel panelEstadoActivo;
	private JPanel panelEstadoInactivo;
	private DefaultListModel <String> pagos= new DefaultListModel<String>();
	private JList<String> listFormasDePago;
	private JTextField txtPorcentajedesc;
	private JLabel lbldiaPromo;
	private JTextField txtDiaPromo;
	private JTextField txtEstado;
	private JLabel lblEstado1;
	private JLabel lblAcumulable;
	private JTextField txtAcumulable;
	private JTextField txtNombre;

	public VentanaPromocionTemporalNuevo() {
		
		pagos.addAll(Local.getInstance().getFormasDePago());
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		setBounds(100, 100, 800, 700);
		panelCreacion = new JPanel();
		getContentPane().add(panelCreacion);
		panelCreacion.setLayout(new GridLayout(3, 3, 0, 0));
		
		lblNombre = new JLabel("Nombre:");
		panelCreacion.add(lblNombre);
		
		txtNombre = new JTextField();
		panelCreacion.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDiaSemana = new JLabel("Forma de Pago:");
		panelCreacion.add(lblDiaSemana);
		
		listFormasDePago = new JList<String>();
		listFormasDePago.setModel(pagos);
		panelCreacion.add(listFormasDePago);
		
		lblPorcentaje = new JLabel("Porcentaje descuento:");
		panelCreacion.add(lblPorcentaje);
		
		txtPorcentajedesc = new JTextField();
		panelCreacion.add(txtPorcentajedesc);
		txtPorcentajedesc.setColumns(10);
		
		panel2 = new JPanel();
		getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(4, 3, 0, 0));
		
		lbldiaPromo = new JLabel("Dia de la Promocion");
		panel2.add(lbldiaPromo);
		
		txtDiaPromo = new JTextField();
		panel2.add(txtDiaPromo);
		txtDiaPromo.setColumns(10);
		
		lblEstado1 = new JLabel("Estado:");
		panel2.add(lblEstado1);
		
		txtEstado = new JTextField();
		panel2.add(txtEstado);
		txtEstado.setColumns(10);
		
		lblAcumulable = new JLabel("Acumulable");
		panel2.add(lblAcumulable);
		
		txtAcumulable = new JTextField();
		panel2.add(txtAcumulable);
		txtAcumulable.setColumns(10);
		
		btnCreacion = new JButton("Creaci??n");
		panel2.add(btnCreacion);
		btnCreacion.setActionCommand("CREAR");
		
		btnVolver = new JButton("Volver");
		panel2.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		
		btnCreacion.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}
	

	public void actualizaLista() {
		this.validate();
	}
	
	public String getProductoSeleccionada() {
		return this.listFormasDePago.getSelectedValue();
	}

	public JTextField getTxtPorcentajedesc() {
		return txtPorcentajedesc;
	}

	public JTextField getTxtDiaPromo() {
		return txtDiaPromo;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public JTextField getTxtAcumulable() {
		return txtAcumulable;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	

}
	
