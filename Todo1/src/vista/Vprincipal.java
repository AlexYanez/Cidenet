package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.net.URI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class Vprincipal extends JFrame {

	/**
	 *  ATENCIÓN: Se ha omitido el Controlador Principal por razones de tiempo y para asegurar la navegavilidad
	 */
	private static final long serialVersionUID = 1L;
	public JMenuItem mntmSalir;
	public JMenuItem mntmRegistrar;
	public JMenuItem mntmConfigVenta;
	public JMenuItem mntmFacturar;
	public JMenuItem mntmRegArticulo;
	public JMenuItem mntmEdiStock;
	private JMenu mnNewMenu;
	private JMenuItem mntmEmpresa;
	private JMenuItem mntmBuscar;
	private Vfondo contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vprincipal frame = new Vprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vprincipal() {
		//Instrucciones de componentes de la vista
		setTitle("Todo1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 449);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnNewMenu_2 = new JMenu("Clientes");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		menuBar.add(mnNewMenu_2);
		
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vcliente vc = new Vcliente(); // Crea la caja de diálogo
				vc.setVisible(true); // Hace visible la caja de diálogo
				
				vc.btnBuscar.setVisible(false);
				vc.btnRegistrar.setVisible(true);
				vc.textNombre.setEditable(true);
				vc.textDireccion.setEditable(true);
				vc.textTelefono.setEditable(true);
				vc.comboEdad.setEditable(true);
				vc.comboSexo.setEditable(true);
				vc.comboCiudad.setEditable(true);
				vc.btnLimpiar.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmRegistrar);
		
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vcliente vc = new Vcliente(); // Crea la caja de diálogo
				vc.setVisible(true); // Hace visible la caja de diálogo
				
				vc.btnBuscar.setVisible(true);
				vc.btnRegistrar.setVisible(false);
				vc.textNombre.setEditable(false);
				vc.textDireccion.setEditable(false);
				vc.textTelefono.setEditable(false);
				vc.comboEdad.setEnabled(false);
				vc.comboSexo.setEnabled(false);
				vc.comboCiudad.setEnabled(false);
				vc.btnLimpiar.setVisible(false);
				
			}
		});
		mnNewMenu_2.add(mntmBuscar);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmConfigVenta = new JMenuItem("Configurar");
		mntmConfigVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vconfigventa vcv;
				vcv = new Vconfigventa();
				vcv.setVisible(true); // Hace visible la vista
			}
		});
		mnVentas.add(mntmConfigVenta);
		
		mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vfactura vf; 
				vf = new Vfactura();
				vf.setVisible(true); // Hace visible la vista
			}
		});
		mnVentas.add(mntmFacturar);
		
		JMenu mnInventario = new JMenu("Inventario");
		menuBar.add(mnInventario);
		
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmRegArticulo = new JMenuItem("Registrar");
		mntmRegArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vproducto vp = new Vproducto();
				
				vp.setVisible(true);
				vp.btnBuscar.setVisible(false);
				vp.btnImportar.setVisible(false);
				vp.btnRegistrar.setEnabled(true);
				vp.btnGuardar.setEnabled(false);
				vp.textProductoID.setEditable(true);
				vp.textCosto.setEditable(true);
				vp.textPrecio.setEditable(true);
				vp.textStockNew.setEditable(true);
				vp.textStockDisp.setVisible(false);
				vp.textDescripcion.setEditable(true);
				vp.comboMarca.setEnabled(true);
				vp.comboModelo.setEnabled(true);
				vp.comboProveedor.setEnabled(true);
				vp.lblStockDisp.setVisible(false);

			}
		});
		mnInventario.add(mntmRegArticulo);
		
		//Metodo auxiliar para hacer conversión de método en comboBox
		mntmEdiStock = new JMenuItem("Editar Stock");
		mntmEdiStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vproducto vp = new Vproducto();
				
				vp.setVisible(true);
				vp.btnBuscar.setVisible(true);
				vp.btnImportar.setVisible(true);
				vp.btnRegistrar.setEnabled(false);
				vp.btnGuardar.setEnabled(true);
				vp.textProductoID.setEditable(true);
				vp.textDefectuso.setEditable(true);
				vp.textCosto.setEditable(false);
				vp.textPrecio.setEditable(false);
				vp.textStockDisp.setVisible(true);
				vp.textDescripcion.setEditable(false);
				vp.comboMarca.setEnabled(false);
				vp.comboModelo.setEnabled(false);
				vp.comboProveedor.setEnabled(false);
				vp.lblStockDisp.setVisible(true);
			}
		});
		mnInventario.add(mntmEdiStock);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Generales");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "En construcción");
			}
		});
		mnReportes.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Espec\u00EDficos");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "En construcción");
			}
		});
		mnReportes.add(mntmNewMenuItem_7);
		
		mnNewMenu = new JMenu("Ayuda");
		menuBar.add(mnNewMenu);
		
		mntmEmpresa = new JMenuItem("Empresa");
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
		mnNewMenu.add(mntmEmpresa);
		
		JMenuItem mntmSistema = new JMenuItem("Sistema");
		mntmSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "En construcción");
			}
		});
		mnNewMenu.add(mntmSistema);
		contentPane = new Vfondo("TODO1-2019-1.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Atajos de teclado
		mntmRegistrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		mntmRegArticulo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		mntmEdiStock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmFacturar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		
		
		
		
		//Cerrar ventana
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
	

}
