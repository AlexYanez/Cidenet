package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Cliente;
import vista.Vcliente;

public class Ccliente {
	
	Cliente c[] = {new Cliente(null, null, 0, null, null, null, null, 0, 0)};
	Vcliente vc = new Vcliente();
	
	
	
	public Ccliente(Cliente[] c, Vcliente vc) {
		super();
		this.c = c;
		this.vc = vc;	
		this.vc.addRegistroListener(new guardarValor());
		this.vc.addBuscarListener(new buscarValor());
		vc.setVisible(true);
	}
	
	public void iniciar() {
		vc.setLocationRelativeTo(null);
	}
		
	// Registrar un valor en el vector
	class guardarValor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				//Verificamos si hay campos vacios para poder guardar
				if (vc.textID.getText().isEmpty() || vc.textNombre.getText().isEmpty() || vc.textTelefono.getText().isEmpty() || vc.textDireccion.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				else {
					//Verificamos que el cliente no esté en memoria
					for (int g = 0; g<c.length; g++)
						if (vc.textID.getText() == c[g].getId()){
							JOptionPane.showMessageDialog(null, "El cliente ya ha sido registrado");
							break;
						}
						//Si ya es el último registro verificado
						else if (c.length == g)
						{
							int x = c.length;
							//Se almacenan los datos ingresados a memoria
							c[x].setId(vc.textID.getText());
							c[x].setNombres(vc.textNombre.getText());
							c[x].setEdad(vc.cantEdad);
							c[x].setSexo(vc.sex);
							c[x].setDireccion(vc.textDireccion.getText());
							c[x].setCiudad(vc.city);
							c[x].setTelefono(vc.textTelefono.getText());
							vc.limpiar();
							JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
						} //end elseif
					} //end else
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error, consulte a Soporte Técnico");
			}
		} //end void
	} //end class
	
	// Buscar un valor en el vector
	class buscarValor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				//Realizamos una búsqueda en memoria
				for (int k =0; k<c.length; k++) {
					//Si lo encontramos, cargamos los valores en pantalla
					if (vc.textID.getText() == c[k].getId()){
						vc.textNombre.setText(c[k].getNombres());
						vc.comboEdad.setSelectedIndex(c[k].getEdad()-15);
						vc.comboSexo.setSelectedIndex(auxSexo(c[k].getSexo()));
						vc.textDireccion.setText(c[k].getDireccion());
						vc.comboCiudad.setSelectedIndex(auxCiudad(c[k].getCiudad()));
						vc.textTelefono.setText(c[k].getTelefono());
					}
					else if (k==c.length)
					{
						JOptionPane.showMessageDialog(null, "Cliente no encontrado");
					break;
					}//End ElseIf
				} //End for
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error, consulte a Soporte Técnico");
			}
		}		
	}
	// Metodo auxiliar para convertir el sexo
	public int auxSexo(String sex) {
		if (sex =="Masculino")
			return 0;
		else
			return 1;
	}
	
	// Metodo auxiliar para convertir la ciudad
	public int auxCiudad(String city) {
		int pos = 0;
		switch (city) {
		case "Bello":
			pos=0;
			break;
		case "Envigado":
			pos=1;
			break;
		case "Estrella":
			pos=2;
			break;
		case "Itagui":
			pos=3;
			break;
		case "medellin":
			pos=4;
			break;
		case "Rionegro":
			pos=5;
			break;
		case "Sabaneta":
			pos=6;
			break;
		}
		return pos;
	}
	
}