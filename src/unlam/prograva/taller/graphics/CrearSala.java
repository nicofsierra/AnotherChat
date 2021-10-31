package unlam.prograva.taller.graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import unlam.prograva.taller.sala.Sala;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class CrearSala extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public CrearSala() {
		setModal(true);
		setBounds(100, 100, 300, 135);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblSala = new JLabel("Sala");
			contentPanel.add(lblSala);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Sala sala = new Sala();
						sala.CrearSala(textField.getText());	
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
}
