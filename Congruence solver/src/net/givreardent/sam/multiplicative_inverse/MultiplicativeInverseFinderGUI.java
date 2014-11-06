package net.givreardent.sam.multiplicative_inverse;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiplicativeInverseFinderGUI extends JFrame {
	private static final long serialVersionUID = -6176264619615164467L;
	private JLabel leftBracket = new JLabel("[");
	private JLabel rightBracket = new JLabel("] in ℤ");
	private JTextField aField = new JTextField(2);
	private JTextField zField = new JTextField(2);
	private JPanel textPanel = new JPanel();
	private JPanel findPanel = new JPanel();
	private JButton findButton = new JButton("Find");
	
	public MultiplicativeInverseFinderGUI() {
		super("Multiplicative inverse finder");
		setSize(200, 105);
		setDefaultCloseOperation(3);
		GridLayout grid = new GridLayout(2,1);
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		setLayout(grid);
		textPanel.setLayout(flow);
		
		textPanel.add(leftBracket);
		textPanel.add(aField);
		textPanel.add(rightBracket);
		textPanel.add(zField);
		
		findPanel.add(findButton);
		
		findButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(aField.getText());
				int z = Integer.parseInt(zField.getText());
				JOptionPane.showMessageDialog(MultiplicativeInverseFinderGUI.this, MultiplicativeInverseFinder.findMultiplcativeInverse(a, z), "Solution", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		add(textPanel);
		add(findPanel);
		
		setVisible(true);
	}
	
	public static void main(String[] arguments) {
		MultiplicativeInverseFinderGUI frame = new MultiplicativeInverseFinderGUI();
	}
}
