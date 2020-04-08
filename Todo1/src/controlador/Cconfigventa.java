package controlador;

import modelo.Configventa;
import vista.Vconfigventa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Cconfigventa {
	
	Vconfigventa vcv = new Vconfigventa();
	Configventa cv = new Configventa(0, 0, 0, 0);
	
	public Cconfigventa(Vconfigventa vcv, Configventa cv) {
		super();
		this.vcv = vcv;
		this.cv = cv;
		this.vcv.addGuardarValores(new guardarConfiguracion());
		vcv.setVisible(true);
		
		//Se cargan por defectos los valores en memoria
		vcv.textConsumo.setText(String.valueOf(cv.getConsumo()));
		vcv.textIva.setText(String.valueOf(cv.getImpuesto()));
		vcv.textFidelidad.setText(String.valueOf(cv.getFidelidad()));
		vcv.textGanancia.setText(String.valueOf(cv.getGanancia()));
	}
	
	class guardarConfiguracion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				//Validamos datos de entrada	
				if (vcv.limiteDescuento()== true) {
					//Se guardan los valores modificados por el usuario
					cv.setConsumo(Integer.valueOf(vcv.textConsumo.getText()));
					cv.setImpuesto(Integer.valueOf(vcv.textIva.getText()));
					cv.setFidelidad(Integer.valueOf(vcv.textFidelidad.getText()));
					cv.setGanancia(Integer.valueOf(vcv.textGanancia.getText()));
					JOptionPane.showMessageDialog(null, "Su producto ha sido guardado");
					vcv.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "La suma de descuentos no puede superar el 100%");
			
			}catch (Exception error){
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error, consulte a Soporte Técnico");
			}
		} //endvoid
	} //endclass
	
}
