package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Vcliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textID;
	public JTextField textNombre;
	public JTextField textTelefono;
	public JTextField textDireccion;
	public JButton btnRegistrar;
	public JButton btnBuscar;
	public JButton btnLimpiar;
	public int cantEdad=0;
	public String sex= "";
	public String city= "";
	public JComboBox comboEdad;
	public JComboBox comboSexo;
	public JComboBox comboCiudad;
	private JMenuItem mntmRegistrar;
	private JMenuItem mntmBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vcliente frame = new Vcliente();
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
	public Vcliente() {
		
		//Componentes de la vista
		setTitle("Cliente");
		setBounds(100, 100, 743, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID Cliente:");
			lblNewLabel.setBounds(25, 34, 76, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(25, 105, 76, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(25, 59, 635, 14);
			contentPanel.add(separator);
		}
		{
			textID = new JTextField();
			textID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					validarCampoNumerico(e);
					if (textID.getText().length() == 10)  
			             e.consume();
				}
			});
			textID.setBounds(111, 31, 146, 20);
			contentPanel.add(textID);
			textID.setColumns(10);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(392, 24, 103, 29);
			contentPanel.add(btnBuscar);
		}
		{
			textNombre = new JTextField();
			textNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					validarCampoTexto(e);
					if (textNombre.getText().length() == 20)  
			             e.consume();
				}
			});
			textNombre.setBounds(111, 102, 210, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		
		comboEdad = new JComboBox();
		comboEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = comboEdad.getSelectedIndex();
				determinarEdad(aux);
			}
		});
		comboEdad.setToolTipText("Seleccione");
		comboEdad.setModel(new DefaultComboBoxModel(new String[] {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"}));
		comboEdad.setBounds(111, 145, 53, 20);
		comboEdad.setSelectedIndex(3);
		contentPanel.add(comboEdad);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setBounds(25, 149, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_3.setBounds(25, 195, 76, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad:");
		lblNewLabel_4.setBounds(25, 241, 76, 14);
		contentPanel.add(lblNewLabel_4);
		
		comboCiudad = new JComboBox();
		comboCiudad.setToolTipText("Seleccione");
		comboCiudad.setModel(new DefaultComboBoxModel(new String[] {"Bello", "Envigado", "Estrella", "Itagui", "Medellin", "Rionegro", "Sabaneta"}));
		comboCiudad.setBounds(111, 237, 146, 20);
		comboCiudad.setSelectedIndex(4);
		contentPanel.add(comboCiudad);
		
		JLabel lblNewLabel_5 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_5.setBounds(25, 280, 76, 14);
		contentPanel.add(lblNewLabel_5);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoNumerico(e);
				if (textTelefono.getText().length() == 10)  
		             e.consume();
			}
		});
		textTelefono.setBounds(111, 277, 146, 20);
		contentPanel.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo:");
		lblNewLabel_6.setBounds(189, 149, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		comboSexo = new JComboBox();
		comboSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = comboSexo.getSelectedIndex();
				determinarSexo(aux);
			}
		});
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboSexo.setBounds(227, 145, 46, 20);
		contentPanel.add(comboSexo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 320, 635, 14);
		contentPanel.add(separator);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(187, 345, 103, 29);
		contentPanel.add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(406, 345, 103, 29);
		contentPanel.add(btnLimpiar);
		
		textDireccion = new JTextField();
		textDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textDireccion.getText().length() == 50)  
		             e.consume();
			}
		});
		textDireccion.setBounds(111, 192, 283, 20);
		contentPanel.add(textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Datos del Cliente:");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setBounds(25, 69, 210, 14);
		contentPanel.add(lblNewLabel_7);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Cerrar todo");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setVisible(false);
				btnRegistrar.setVisible(true);
				textNombre.setEditable(true);
				textDireccion.setEditable(true);
				textTelefono.setEditable(true);
				comboEdad.setEditable(true);
				comboSexo.setEditable(true);
				comboCiudad.setEditable(true);
				btnLimpiar.setVisible(true);
			}
		});
		mnHerramientas.add(mntmRegistrar);
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setVisible(true);
				btnRegistrar.setVisible(false);
				textNombre.setEditable(false);
				textDireccion.setEditable(false);
				textTelefono.setEditable(false);
				comboEdad.setEnabled(false);
				comboSexo.setEnabled(false);
				comboCiudad.setEnabled(false);
				btnLimpiar.setVisible(false);
			}
		});
		mnHerramientas.add(mntmBuscar);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Empresa");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI ("https://todo1services.com/"));
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "No se puede ejecutar");
					}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sistema");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "En construcción");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		mntmRegistrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		
		addWindowListener((WindowListener) new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
                int x = JOptionPane.showConfirmDialog(null, 
                    "¿Estás seguro de salir?", "Confirmar !",
                    JOptionPane.YES_NO_OPTION);

                if(x == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }else{
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });		 
	}
	
	//Metodos para el listener de los botones
	public void addRegistroListener(ActionListener rl){
		btnRegistrar.addActionListener(rl);
	}
	public void addBuscarListener(ActionListener bl) {
		btnBuscar.addActionListener(bl);
	}
		
	//Auxiliares para los JComboBox	
	void determinarEdad(int index) {
		cantEdad = index+15;
	}
	void determinarSexo(int index) {
		if (index == 0)
			sex = "Masculino";
		else
			sex = "Femenino";
	}
	
	//Metodo para determinar la ciudad
	void determinarCiudad(int index) {
		switch (index) {
		case 0:
			city="Bello";
			break;
		case 1:
			city="Envigado";
			break;
		case 2:
			city = "Estrella";
			break;
		case 3:
			city = "Itagui";
			break;
		case 4:
			city = "Medellin";
			break;
		case 5:
			city = "Rionegro";
			break;
		case 6:
			city = "Sabaneta";
			break;
		}
	}
	
	//Utilidades
	public void validarCampoNumerico(KeyEvent k) {
		char validar = k.getKeyChar();
			if (Character.isLetter(validar)) {
				getToolkit().beep();
				k.consume();
			}
	}
	public void validarCampoTexto(KeyEvent k) {
		char validar = k.getKeyChar();
			if (Character.isDigit(validar)) {
				getToolkit().beep();
				k.consume();
			}
	}

	public void limpiar() {
		textID.setText(" ");
		textNombre.setText(" ");
		textTelefono.setText(" ");
		textDireccion.setText(" ");
	}

}
