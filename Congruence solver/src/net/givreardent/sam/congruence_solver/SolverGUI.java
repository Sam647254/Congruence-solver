package net.givreardent.sam.congruence_solver;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SolverGUI extends JFrame {
	private static final long serialVersionUID = -3627170996697955776L;

	private JTextField aField = new JTextField(2);
	private JTextField cField = new JTextField(2);
	private JTextField mField = new JTextField(2);
	private JLabel xLabel = new JLabel("x ≡ ");
	private JLabel modLabel = new JLabel(" (mod ");
	private JLabel closeBracket = new JLabel(")");
	private JButton solveButton = new JButton("Solve");
	
	public SolverGUI() {
		super("Congruence solver");
		setSize(220, 100);
		setDefaultCloseOperation(3); // exit on close
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);
		add(aField);
		aField.setHorizontalAlignment(JTextField.RIGHT);
		add(xLabel);
		add(cField);
		cField.setHorizontalAlignment(JTextField.RIGHT);
		add(modLabel);
		add(mField);
		mField.setHorizontalAlignment(JTextField.RIGHT);
		add(closeBracket);
		add(solveButton);
		solveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Object source = event.getSource();
				if (source == solveButton) {
					int a = Integer.parseInt(aField.getText());
					int c = Integer.parseInt(cField.getText());
					int m = Integer.parseInt(mField.getText());
					String result = LinearCongruenceSolver.solveCongruence(a, c, m);
					JOptionPane.showMessageDialog(SolverGUI.this, result, "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		setVisible(true);
	}
	
	public static void main(String[] arguments) {
		SolverGUI frame = new SolverGUI();
	}
}
