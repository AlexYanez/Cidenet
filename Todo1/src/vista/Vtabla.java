package vista;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vtabla extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo = new DefaultTableModel();
	private final JPanel contentPanel = new JPanel();
	public JTable tableProducto;
	private JTextField textBuscar;
	public JTextField textDescripcion;
	public JTextField textCodigo;
	public String d = " ";
	Vfactura vf = new Vfactura();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vtabla dialog = new Vtabla();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 */
	public Vtabla() {
		setTitle("Buscar Producto");
		setBounds(100, 100, 565, 345);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 549, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setBounds(10, 35, 53, 14);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 78, 478, 217);
		getContentPane().add(scrollPane);
		
		tableProducto = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			//Metodo para hacer la tabla ineditable
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tableProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = tableProducto.getSelectedRow();
				textCodigo.setText(String.valueOf(tableProducto.getValueAt(seleccion, 0)));
				textDescripcion.setText(String.valueOf(tableProducto.getValueAt(seleccion, 1)));
			}
		});
		tableProducto.setModel(new DefaultTableModel(
			new Object[][] {
				{01, "Hola", "carro", "perro", 10, 1},
				{02, "Pedro", null, null, null},
				{03, "Jose", null, null, null, null},
				{04, "Richard", null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Producto ID", "Descripcion", "Marca", "Modelo", "Precio", "Stock"
			}
		));
		scrollPane.setViewportView(tableProducto);
		
		
		textBuscar = new JTextField();
		textBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel table = (DefaultTableModel)tableProducto.getModel();
				String search = textBuscar.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
				tableProducto.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter("(?i)"+search, 1,2,3));
			}
		});
		textBuscar.setBounds(60, 32, 148, 20);
		getContentPane().add(textBuscar);
		textBuscar.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(356, 32, 115, 20);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(306, 32, 40, 20);
		getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionaste:");
		lblNewLabel_1.setBounds(218, 35, 115, 14);
		getContentPane().add(lblNewLabel_1);
		
		//Metodo en construcción para importar los datos
		JButton btnAvanzar = new JButton("Avanzar");
		btnAvanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//d = textDescripcion.getText();
				String k = String.valueOf(textCodigo.getText());
				d = String.valueOf(textDescripcion.getText());
				vf.llenarCampos(k, d);
				vf.textDescripcion.setText(textDescripcion.getText());
				setVisible(false);
			}
		});
		btnAvanzar.setBounds(415, 3, 89, 23);
		getContentPane().add(btnAvanzar);
	}
}
