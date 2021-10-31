package unlam.prograva.taller.graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JChat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JChat frame = new JChat();
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
	public JChat() {
		setTitle("Sala -");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 12, 288, 184);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(25, 207, 351, 54);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton(">");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(388, 207, 44, 53);
		contentPane.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(325, 12, 107, 184);
		contentPane.add(panel_1);
	}

}
