package prog_5_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 * Purpose: Create a Java Program to count letters, reverse letters and remove duplicates 
 * and output the result to an Output JTextField
 * @author Adeola Adeleke
 * Date: 09/10/2019
 * Lab Number: 5
 *
 */
public class Exercise_5_2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFieldInput;
	private JTextField txtFieldOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise_5_2 frame = new Exercise_5_2();
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
	public Exercise_5_2() {
		setResizable(false);
		setTitle("Swing GUI Exercise 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCountLetters = new JButton("Count Letters");
		btnCountLetters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtVal = txtFieldInput.getText();
				int count = txtVal.length();
				txtFieldOutput.setText("Count is "+count);
			}
		});
		btnCountLetters.setBounds(32, 41, 150, 32);
		contentPane.add(btnCountLetters);
		
		JButton btnReveredLetters = new JButton("Revered Letters");
		btnReveredLetters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String txtVal = txtFieldInput.getText();
				StringBuilder sb = new StringBuilder(txtVal);
				txtFieldOutput.setText(sb.reverse().toString());
				
			}
		});
		btnReveredLetters.setBounds(32, 114, 150, 32);
		contentPane.add(btnReveredLetters);
		
		JButton btnRemoveDuplicates = new JButton("Remove Duplicates");
		btnRemoveDuplicates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove duplicates
				String txt = txtFieldInput.getText();
				//System.out.println("Input: "+txt);
				if(txt != null) {
					String sb = new String();
					for(int i=0;i<txt.length();i++) 
						if(!sb.contains(txt.charAt(i)+""))
							sb += txt.charAt(i);
					
					
				   txtFieldOutput.setText(sb);
				}
			}
		});
		btnRemoveDuplicates.setBounds(32, 187, 150, 32);
		contentPane.add(btnRemoveDuplicates);
		
		txtFieldInput = new JTextField();
		txtFieldInput.setBounds(244, 99, 158, 32);
		contentPane.add(txtFieldInput);
		txtFieldInput.setColumns(10);
		
		txtFieldOutput = new JTextField();
		txtFieldOutput.setColumns(10);
		txtFieldOutput.setBounds(244, 168, 158, 32);
		contentPane.add(txtFieldOutput);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(244, 70, 46, 14);
		contentPane.add(lblInput);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(244, 142, 46, 14);
		contentPane.add(lblOutput);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldInput.setText("");
				txtFieldOutput.setText("");
			}
		});
		btnClear.setBounds(323, 35, 79, 23);
		contentPane.add(btnClear);
	}
}
