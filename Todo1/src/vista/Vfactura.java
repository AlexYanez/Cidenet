package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Vfactura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textClienteID;
	public JTextField textNombre;
	public JTextField textFacturaID;
	public JTextField textSubTotal;
	public JTextField textIVA;
	public JTextField textTotal;
	public JTextField textProductoID;
	public JTextField textDescuento;
	public JTextField textDescripcion;
	public JButton btnBuscar;
	public JButton btnVer;
	public JButton btnProcesar;
	public JButton btnAgregar;
	public JButton btnQuitar;
	
	public JComboBox comboCantidad;
	public JComboBox comboPago;
	public JComboBox comboEmpleado;
	public int cant; //Auxiliar global que permite conocer el estatus del JcomboBox
	int cont; //Auxiliar para contar la cantidad de productos
	public int i = 0; //Iterador global del metodo facturar, permite contar los productos agregados a la tabla
	DefaultTableModel model;
	public JTable tableFactura;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vfactura frame = new Vfactura();
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
	public Vfactura() {
		//Datos de los componentes Swing utilizados para la vista		
		setTitle("Facturar");
		setBounds(100, 100, 732, 477);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cliente ID:");
			lblNewLabel.setBounds(15, 43, 86, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textClienteID = new JTextField();
			textClienteID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					validarCampoNumerico(e);
					}
							
			});
			textClienteID.setBounds(95, 40, 107, 20);
			contentPanel.add(textClienteID);
			textClienteID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(403, 43, 75, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textNombre = new JTextField();
			textNombre.setEditable(false);
			textNombre.setColumns(10);
			textNombre.setBounds(460, 40, 202, 20);
			contentPanel.add(textNombre);
		}
		{
			JButton btnProcesar = new JButton("Procesar");
			btnProcesar.setBounds(113, 397, 113, 30);
			contentPanel.add(btnProcesar);
		}
		{
			JButton btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiar();	
				}
			});
			btnLimpiar.setBounds(304, 397, 113, 30);
			contentPanel.add(btnLimpiar);
		}
		{
			textFacturaID = new JTextField();
			textFacturaID.setEditable(false);
			textFacturaID.setBounds(553, 75, 106, 20);
			contentPanel.add(textFacturaID);
			textFacturaID.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Datos del cliente:");
			lblNewLabel_2.setForeground(new Color(0, 128, 0));
			lblNewLabel_2.setBounds(15, 11, 274, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(15, 68, 656, 14);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Factura: ");
			lblNewLabel_3.setBounds(479, 78, 64, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Detalle factura: ");
			lblNewLabel_4.setForeground(new Color(0, 128, 0));
			lblNewLabel_4.setBounds(15, 78, 187, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Empleado:");
			lblNewLabel_5.setBounds(195, 78, 75, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JComboBox comboEmpleado = new JComboBox();
			comboEmpleado.setModel(new DefaultComboBoxModel(new String[] {"Jes\u00FAs Ospina", "Carlos P\u00E9rez", "Martha Linarez", "Oscar Silva"}));
			comboEmpleado.setBounds(265, 74, 129, 22);
			contentPanel.add(comboEmpleado);
		}
		{
			// Buscar cliente
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(205, 38, 75, 25);
			contentPanel.add(btnBuscar);
		}
		{
			textSubTotal = new JTextField();
			textSubTotal.setEditable(false);
			textSubTotal.setBounds(535, 325, 86, 20);
			contentPanel.add(textSubTotal);
			textSubTotal.setColumns(10);
		}
		{
			textIVA = new JTextField();
			textIVA.setEditable(false);
			textIVA.setBounds(535, 356, 86, 20);
			contentPanel.add(textIVA);
			textIVA.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Stotal:");
			lblNewLabel_6.setBounds(479, 328, 46, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("IVA:");
			lblNewLabel_7.setBounds(479, 359, 46, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			textTotal = new JTextField();
			textTotal.setEditable(false);
			textTotal.setBounds(535, 387, 86, 20);
			contentPanel.add(textTotal);
			textTotal.setColumns(10);
		}
		{
			textProductoID = new JTextField();
			textProductoID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					validarCampoNumerico(e);			
				}
			});
			textProductoID.setBounds(95, 114, 75, 20);
			contentPanel.add(textProductoID);
			textProductoID.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Producto ID:");
			lblNewLabel_8.setBounds(15, 117, 86, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Cantidad a llevar:");
			lblNewLabel_9.setBounds(323, 117, 113, 14);
			contentPanel.add(lblNewLabel_9);
		}
		{
			JComboBox comboCantidad = new JComboBox();
			comboCantidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cant = comboCantidad.getSelectedIndex();
				}
			});
			comboCantidad.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
			comboCantidad.setBounds(432, 109, 46, 22);
			contentPanel.add(comboCantidad);
		}
		
		
		{
			JLabel lblNewLabel_10 = new JLabel("Forma de pago:");
			lblNewLabel_10.setBounds(265, 140, 107, 14);
			contentPanel.add(lblNewLabel_10);
		}
		{
			JComboBox comboPago = new JComboBox();
			comboPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta de d\u00E9bito", "Tarjeta de cr\u00E9dito", "Cesta Tickets", "Otro"}));
			comboPago.setBounds(352, 136, 126, 22);
			contentPanel.add(comboPago);
		}
		{
			JLabel lblNewLabel_11 = new JLabel("Total:");
			lblNewLabel_11.setBounds(479, 390, 46, 14);
			contentPanel.add(lblNewLabel_11);
		}
		{
			JLabel lblNewLabel_12 = new JLabel("Descuento:");
			lblNewLabel_12.setBounds(230, 328, 98, 14);
			contentPanel.add(lblNewLabel_12);
		}
		{
			textDescuento = new JTextField();
			textDescuento.setEditable(false);
			textDescuento.setBounds(308, 325, 86, 20);
			contentPanel.add(textDescuento);
			textDescuento.setColumns(10);
		}
		{
			JButton btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(489, 106, 89, 62);
			contentPanel.add(btnAgregar);
		}
		{
			// Este método se ejecuta al presionar el boton Quitar, se usa para remover una fila
			JButton btnQuitar = new JButton("Quitar");
			btnQuitar.setBounds(588, 106, 89, 62);
			contentPanel.add(btnQuitar);
		}
		{
			JLabel lblNewLabel_13 = new JLabel("Descripci\u00F3n: ");
			lblNewLabel_13.setBounds(15, 145, 86, 14);
			contentPanel.add(lblNewLabel_13);
		}
		{
			textDescripcion = new JTextField();
			textDescripcion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				}
			});
			textDescripcion.setBounds(95, 145, 142, 20);
			contentPanel.add(textDescripcion);
			textDescripcion.setColumns(10);
		}
		{
			JButton btnVer = new JButton("Ver");
			btnVer.setBounds(171, 113, 66, 23);
			contentPanel.add(btnVer);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 189, 630, 131);
			contentPanel.add(scrollPane);
			{
				tableFactura = new JTable() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					//Metodo para hacer la tabla ineditable
					public boolean isCellEditable(int rowIndex, int colIndex) {
						return false;
					}
				};
				
				
				tableFactura.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
					},
					new String[] {
						"Cantidad", "Descripcion", "Precio"
					}
				));
				scrollPane.setViewportView(tableFactura);
			}
		}
		
		
		/*
		 * Metodo a implementar para permitir buscar Productos en otra tabla
		 * 
		JButton btnImportar = new JButton("Abrir");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vtabla vt = new Vtabla();
				textDescripcion.setText(vt.d);
				System.out.print(vt.d);
			}
		});
		btnImportar.setBounds(285, 38, 75, 25);
		contentPanel.add(btnImportar);
		*/
		
		// Este método muestra una ventaja emergente para confirmar salir
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
        }); //Fin de Listener
	} // Fin de VFacturar
	
//Métodos de uso aritmético locales	

	public void llenarCampos(String m, String n)
	{
		textClienteID.setText("123");
		textProductoID.setText (m);
		System.out.print(m);
		textDescripcion.setText(n);
		System.out.print(n);
	}
	
	//Metodo de apoyo para la suma de los valores de las columnas
	public Double sumarColumna(int n) {
		Double fila = 0.0;
		Double sumatoria = 0.0; 
		fila = Double.parseDouble(tableFactura.getValueAt(i-1, n).toString());
		sumatoria = sumatoria + fila;
		return sumatoria;
	}

//Metodos de utilidades locales
	// Este método limpia los campos de VFacturar
		public void limpiar() {
			model = (DefaultTableModel) tableFactura.getModel();
			
			for (int m = 0; m < tableFactura.getColumnCount(); m++)
				for (int n = 0; n < tableFactura.getRowCount(); n++)
					tableFactura.setValueAt(null, n, m);		
			
			i=0; //Reiniciamos i, el cual es nuestro pivot de referencia de ubicación de la tabla
			//Reseteamos los valores en las cajas de texto
			textProductoID.setText(null);
			textDescripcion.setText("hola");
			textClienteID.setText(null);
			textNombre.setText(null);
			textSubTotal.setText(null);
			textIVA.setText(null);
			textTotal.setText(null);
			model.fireTableDataChanged();
		} // Fin de limpiar
		
		//Utilidades
		//Validar campo
		public void validarCampoNumerico(KeyEvent k) {
			char validar = k.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					k.consume();
				}
		}
		
		//Metodo auxiliar para hacer conversión de método en comboBox
		public String determinarEmpleado(int index) {
			String em = "";
			switch (index) {
			case 0:
				em="Jesus Ospina";
				break;
			case 1:
				em="Carlos Perez";
				break;
			case 2:
				em = "Martha Linarez";
				break;
			case 3:
				em = "Oscar Silva";
				break;
			}
			return em;
		}
		//Metodo auxiliar para hacer conversión de método en comboBox
		public String determinarMedPago(int index) {
			String mp = "";
			switch (index) {
			case 0:
				mp="Efectivo";
				break;
			case 1:
				mp="Debito";
				break;
			case 2:
				mp = "Credito";
				break;
			case 3:
				mp = "Cesta Tickets";
				break;
			case 4:
				mp = "Otro";
				break;
			}
			return mp;
		}
		
		//Metodos para el listener de los botones
		public void addAgregarListener(ActionListener rl){
			btnAgregar.addActionListener(rl);
		}
		public void addQuitarListener(ActionListener bl) {
			btnQuitar.addActionListener(bl);
		}
		public void addBuscarListener(ActionListener rl){
			btnBuscar.addActionListener(rl);
		}
		public void addVerListener(ActionListener bl) {
			btnVer.addActionListener(bl);
		}
		public void addProcesarListener(ActionListener bl) {
			btnProcesar.addActionListener(bl);
		}
		

} // Fin de JFrame
