package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Vconfigventa extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textFidelidad;
	public JTextField textGanancia;
	public JTextField textDefectos;
	public JTextField textConsumo;
	public JButton btnGuardarConfig;
	public JTextField textIva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vconfigventa frame = new Vconfigventa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Vconfigventa() {
		setTitle("Configuraci\u00F3n de Venta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IVA (%):");
		lblNewLabel.setBounds(26, 31, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descuento:");
		lblNewLabel_1.setBounds(38, 95, 96, 14);
		contentPanel.add(lblNewLabel_1);
		
		textIva = new JTextField();
		textIva.setBounds(99, 28, 46, 20);
		contentPanel.add(textIva);
		textIva.setColumns(10);
		
		textFidelidad = new JTextField();
		textFidelidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoNumerico(e);
				if (textFidelidad.getText().length() == 2)  
		             e.consume();
			}
		});
		textFidelidad.setBounds(190, 117, 46, 20);
		contentPanel.add(textFidelidad);
		textFidelidad.setColumns(10);
		
		JTextField textConsumo = new JTextField();
		textConsumo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoNumerico(e);
				if (textFidelidad.getText().length() == 2)  
		             e.consume();
			}
		});
		textConsumo.setBounds(190, 146, 46, 20);
		contentPanel.add(textConsumo);
		textConsumo.setColumns(10);
		
		btnGuardarConfig = new JButton("Guardar");
		btnGuardarConfig.setBounds(167, 206, 106, 32);
		contentPanel.add(btnGuardarConfig);
		
		JTextField textGanancia = new JTextField();
		textGanancia.setColumns(10);
		textGanancia.setBounds(314, 31, 46, 20);
		contentPanel.add(textGanancia);
		
		JLabel lblGanancia = new JLabel("Tasa Ganancia (%):");
		lblGanancia.setBounds(188, 31, 116, 14);
		contentPanel.add(lblGanancia);
		
		JLabel lblFidelidad = new JLabel("Fidelidad (%):");
		lblFidelidad.setBounds(88, 120, 92, 14);
		contentPanel.add(lblFidelidad);
		
		JLabel lblConsumo = new JLabel("Consumo (%):");
		lblConsumo.setBounds(88, 149, 92, 14);
		contentPanel.add(lblConsumo);
	}
	
	// Utilidades
	// Metodo para validar el ingreso solo de campos numericos
	void validarCampoNumerico(KeyEvent k) {
		char validar = k.getKeyChar();
			if (Character.isLetter(validar)) {
				getToolkit().beep();
				k.consume();
			}
	}
	
	// Metodo para validar el ingreso de descuentos, que no supere el 100%
	public boolean limiteDescuento() {
		int valor = 0;
		boolean ask = true;
		valor = Integer.parseInt(textFidelidad.getText()) + Integer.parseInt(textConsumo.getText());
		if (valor > 99)
			ask = false;
			
		return ask;
	}

	// Metodos para el listener de los botones
	public void addGuardarValores(ActionListener gv){
		btnGuardarConfig.addActionListener(gv);
	}
	
}
