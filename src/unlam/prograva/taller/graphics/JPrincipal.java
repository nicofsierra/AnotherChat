package unlam.prograva.taller.graphics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import unlam.prograva.taller.sala.Sala;

public class JPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		
		List<String> salas = new ArrayList<String>();
		Sala sala = new Sala();
		salas = sala.getSalas();
		
		setTitle("Another Chat - Lobby ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JLabel lblSalasActivas = new JLabel("Salas Activas");
		lblSalasActivas.setBounds(25, 12, 107, 15);
		contentPane.add(lblSalasActivas);
		
		textField = new JTextField();
		textField.setBounds(97, 184, 283, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 186, 70, 15);
		contentPane.add(lblNombre);
		
		JButton btnCrearSala = new JButton("Crear Sala");
		btnCrearSala.setBounds(45, 224, 117, 25);
		
		btnCrearSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaCrearSala();
			}
		});
		contentPane.add(btnCrearSala);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(263, 224, 117, 25);
		contentPane.add(btnNewButton_1);
		
		DefaultListModel model = new DefaultListModel();
		
		//JList<String> list = new JList<>( model );
		
		/*DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );*/

		for ( String s : salas) {
			model.addElement(s);
		}
		
		JList list = new JList(model);
		list.setBounds(35, 39, 384, 132);
		contentPane.add(list);
		System.out.println(sala.toString());
		
	}
	
	public void abrirVentanaCrearSala() {
		CrearSala sala = new CrearSala();
		//jCliente.cargaIconoVentana(".\\agregar.png");
		//sala.seteaComportamientoBoton("Crear");
		sala.setVisible(true);
	}
}
