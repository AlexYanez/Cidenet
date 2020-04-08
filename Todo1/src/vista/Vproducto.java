package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
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

import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Vproducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textProductoID;
	public JTextField textCosto;
	public JTextField textPrecio;
	public JTextField textStockDisp;
	public JTextField textStockNew;
	public JTextField textDefectuso;
	public JTextField textDescripcion;
	public JButton btnBuscar;
	public JButton btnImportar;
	public JComboBox comboMarca;
	public JComboBox comboProveedor;
	public JComboBox comboModelo;
	public JButton btnGuardar;
	public JLabel lblStockDisp;
	public String model = "";
	public String mark = "";
	public String prov= "";
	private JMenuItem mntmRegistrar;
	private JMenuItem mntmEditarStock;
	public JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vproducto frame = new Vproducto();
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
	public Vproducto() {
		
		//Instrucciones para la construcción de la vista
		setTitle("Inventario");
		setBounds(100, 100, 738, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Producto:");
		lblNewLabel.setBounds(36, 44, 82, 14);
		contentPanel.add(lblNewLabel);
		
		textProductoID = new JTextField();
		textProductoID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarCampoNumerico(e);
			}
		});
		textProductoID.setEditable(false);
		textProductoID.setBounds(128, 41, 86, 20);
		contentPanel.add(textProductoID);
		textProductoID.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnBuscar.setBounds(217, 37, 104, 29);
		contentPanel.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 77, 639, 14);
		contentPanel.add(separator);
		
		comboMarca = new JComboBox();
		comboMarca.setModel(new DefaultComboBoxModel(new String[] {"Adidas", "Nike", "Tommy", "Boss"}));
		comboMarca.setBounds(128, 126, 122, 22);
		contentPanel.add(comboMarca);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(36, 130, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Costo:");
		lblNewLabel_2.setBounds(36, 176, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textCosto = new JTextField();
		textCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarCampoNumerico(e);
			}
		});
		textCosto.setEditable(false);
		textCosto.setColumns(10);
		textCosto.setBounds(128, 173, 104, 20);
		contentPanel.add(textCosto);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(325, 176, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		textPrecio = new JTextField();
		textPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarCampoNumerico(e);
			}
		});
		textPrecio.setEditable(false);
		textPrecio.setBounds(417, 173, 104, 20);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
		
		lblStockDisp = new JLabel("Stock disponible:");
		lblStockDisp.setBounds(36, 276, 94, 14);
		contentPanel.add(lblStockDisp);
		
		textStockDisp = new JTextField();
		textStockDisp.setEditable(false);
		textStockDisp.setBounds(128, 273, 46, 20);
		contentPanel.add(textStockDisp);
		textStockDisp.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo:");
		lblNewLabel_5.setBounds(325, 126, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		comboModelo = new JComboBox();
		comboModelo.setModel(new DefaultComboBoxModel(new String[] {"T-Spiderman", "Captain America", "CiBatman", "T-1000"}));
		comboModelo.setBounds(417, 126, 129, 22);
		contentPanel.add(comboModelo);
		
		JLabel lblNewLabel_6 = new JLabel("Proveedor:");
		lblNewLabel_6.setBounds(36, 224, 94, 14);
		contentPanel.add(lblNewLabel_6);
		
		comboProveedor = new JComboBox();
		comboProveedor.setModel(new DefaultComboBoxModel(new String[] {"Modasoft", "Medalca", "Clothes Import", "Superestrella"}));
		comboProveedor.setBounds(128, 220, 122, 22);
		contentPanel.add(comboProveedor);
		
		JLabel lblNewLabel_7 = new JLabel("Nuevo Stock:");
		lblNewLabel_7.setBounds(325, 276, 94, 14);
		contentPanel.add(lblNewLabel_7);
		
		textStockNew = new JTextField();
		textStockNew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarCampoNumerico(e);
			}
		});
		textStockNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textProductoID.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe indicar el producto");
				else
					JOptionPane.showMessageDialog(null, "Muy bien");
					
			}
		});
		textStockNew.setEditable(false);
		textStockNew.setBounds(417, 273, 46, 20);
		contentPanel.add(textStockNew);
		textStockNew.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Defectuosos:");
		lblNewLabel_8.setBounds(325, 224, 94, 14);
		contentPanel.add(lblNewLabel_8);
		
		textDefectuso = new JTextField();
		textDefectuso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarCampoNumerico(e);
			}
		});
		textDefectuso.setEditable(false);
		textDefectuso.setColumns(10);
		textDefectuso.setBounds(417, 221, 46, 20);
		contentPanel.add(textDefectuso);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 316, 639, 2);
		contentPanel.add(separator_1);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textProductoID.getText().isEmpty() || textCosto.getText().isEmpty() || textPrecio.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe cargar productos a facturar");
				else
					JOptionPane.showMessageDialog(null, "Muy bien");
					Limpiar();
			}
		});
		btnGuardar.setBounds(290, 356, 104, 29);
		contentPanel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(469, 356, 104, 29);
		contentPanel.add(btnLimpiar);
		
		JLabel lblNewLabel_9 = new JLabel("Datos de Inventario:");
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setBounds(36, 7, 427, 14);
		contentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Datos de producto:");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setBounds(36, 91, 196, 14);
		contentPanel.add(lblNewLabel_10);
		
		//Metodo en construcción para importar datos
		btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vtabla vt; // Declarar el nombre de la caja de diálogo
				vt = new Vtabla(); // Crea la caja de diálogo
				vt.setVisible(true); // Hace visible la caja de diálogo
			}
		});
		btnImportar.setBounds(331, 37, 104, 29);
		contentPanel.add(btnImportar);
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(260, 88, 186, 20);
		contentPanel.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_4.setBounds(180, 91, 82, 14);
		contentPanel.add(lblNewLabel_4);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(106, 356, 104, 29);
		contentPanel.add(btnRegistrar);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Cerrar todo");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmSalir);
		
		JMenu mnNewMenu_1 = new JMenu("Herramientas");
		menuBar.add(mnNewMenu_1);
		
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setVisible(false);
				btnImportar.setVisible(false);
				btnRegistrar.setEnabled(true);
				btnGuardar.setEnabled(false);
				textProductoID.setEditable(true);
				textCosto.setEditable(true);
				textPrecio.setEditable(true);
				textStockNew.setEditable(true);
				textStockDisp.setVisible(false);
				textDescripcion.setEditable(true);
				comboMarca.setEnabled(true);
				comboModelo.setEnabled(true);
				comboProveedor.setEnabled(true);
				lblStockDisp.setVisible(false);
				
			}
		});
		mnNewMenu_1.add(mntmRegistrar);
		
		//Metodos que manipula los botones de la vista de acuerdo a condiciones
		mntmEditarStock = new JMenuItem("Editar Stock");
		mntmEditarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setVisible(true);
				btnImportar.setVisible(true);
				btnRegistrar.setEnabled(false);
				btnGuardar.setEnabled(true);
				textProductoID.setEditable(true);
				textDefectuso.setEditable(true);
				textStockDisp.setVisible(true);
				textCosto.setEditable(false);
				textPrecio.setEditable(false);
				textDescripcion.setEditable(false);
				comboMarca.setEnabled(false);
				comboModelo.setEnabled(false);
				comboProveedor.setEnabled(false);
				lblStockDisp.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmEditarStock);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mntmEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI ("https://todo1services.com/"));
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "No se puede ejecutar");
					}
			}
		});
		mnNewMenu_2.add(mntmEmpresa);
		
		JMenuItem mntmSistema = new JMenuItem("Sistema");
		mntmSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "En construcción");
			}
		});
				
		mnNewMenu_2.add(mntmSistema);
		
		//Atajos de teclado
		mntmRegistrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		mntmEditarStock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
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
	
	//Metodos listener de botones para el Controlador
	public void addGuardarListener(ActionListener gl){
		btnGuardar.addActionListener(gl);
	}
	public void addBuscarListener(ActionListener bl) {
		btnBuscar.addActionListener(bl);
	}
	public void addRegistrarListener(ActionListener rl) {
		btnRegistrar.addActionListener(rl);
	}
	
	
	
//Auxiliares para los JComboBox	
	//Metodo para determinar modelo
	void determinarModelo(int index) {
		switch (index) {
			case 0:
				model="T-Spiderman";
				break;
			case 1:
				model="Captain America";
				break;
			case 2:
				model = "CiBatman";
				break;
			case 3:
				model = "T-1000";
				break;
			}
		}
	//Metodo para determinar marca
	void determinarMarca(int index) {
		switch (index) {
			case 0:
				mark="Adidas";
				break;
			case 1:
				mark="Nike";
				break;
			case 2:
				mark ="Tommy";
				break;
			case 3:
				mark ="Boss";
				break;
			}
	}
		
	//Metodo para determinar proveedor 
	void determinarProveedor(int index) {
		switch (index) {
			case 0:
				prov="Modasoft";
				break;
			case 1:
				prov="Medalca";
				break;
			case 2:
				prov ="Clothes Import";
				break;
			case 3:
				prov ="Superestrella";
				break;
		}
	}

//Utilidades
	public void ValidarCampoNumerico(KeyEvent k) {
		char validar = k.getKeyChar();
			if (Character.isLetter(validar)) {
				getToolkit().beep();
				k.consume();
			}
	}
	
	public void Limpiar() {
		textProductoID.setText(" ");
		textCosto.setText(" ");
		textPrecio.setText(" ");
		textStockDisp.setText(" ");
		textStockNew.setText(" ");
		textDefectuso.setText(" ");
	}
}
