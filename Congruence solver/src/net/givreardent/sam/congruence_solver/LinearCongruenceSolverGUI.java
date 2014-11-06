package net.givreardent.sam.congruence_solver;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LinearCongruenceSolverGUI extends JFrame {
	private static final long serialVersionUID = -3627170996697955776L;

	private JPanel mode1 = new JPanel();
	private JPanel mode2 = new JPanel();
	private JPanel modeSelection = new JPanel();
	private JPanel solvePanel = new JPanel();
	private JPanel switchPanel = new JPanel();
	private JRadioButton[] modes = { new JRadioButton("Normal", true), new JRadioButton("Congruence class") };
	private ButtonGroup modeButtons = new ButtonGroup();
	private JTextField aField1 = new JTextField(2);
	private JTextField cField1 = new JTextField(2);
	private JTextField mField1 = new JTextField(2);
	private JTextField aField2 = new JTextField(2);
	private JTextField cField2 = new JTextField(2);
	private JTextField mField2 = new JTextField(2);
	private JLabel xLabel = new JLabel("x ≡ ");
	private JLabel modLabel = new JLabel(" (mod ");
	private JLabel closeBracket = new JLabel(")");
	private JLabel leftBracket = new JLabel("[");
	private JLabel xBracket = new JLabel("][x] = [");
	private JLabel ZSet = new JLabel("] in ℤ");
	private JButton solveButton = new JButton("Solve");
	private CardLayout card = new CardLayout();
	private int currentMode = 0;
	
	public LinearCongruenceSolverGUI() {
		super("Congruence solver");
		setSize(220, 150);
		setDefaultCloseOperation(3); // exit on close
		GridLayout grid = new GridLayout(3,1);
		setLayout(grid);
		
		modeButtons.add(modes[0]);
		modeButtons.add(modes[1]);
		
		modes[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(switchPanel, "Mode 1");
				currentMode = 0;
			}
			
		});
		modes[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(switchPanel, "Mode 2");
				currentMode = 1;
			}
			
		});
		
		initializePanels();
		
		add(modeSelection);
		add(switchPanel);
		
		if(modes[0].isSelected())
			card.show(switchPanel, "Mode 1");
		add(solvePanel);
		pack();
		setVisible(true);
	}
	
	
	public static void main(String[] arguments) {
		LinearCongruenceSolverGUI frame = new LinearCongruenceSolverGUI();
	}
	
	private void initializePanels() {
		GridLayout grid = new GridLayout(2,1);
		modeSelection.setLayout(grid);
		modeSelection.add(modes[0]);
		modeSelection.add(modes[1]);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		mode1.setLayout(layout);
		mode1.add(aField1);
		aField1.setHorizontalAlignment(JTextField.RIGHT);
		mode1.add(xLabel);
		mode1.add(cField1);
		cField1.setHorizontalAlignment(JTextField.RIGHT);
		mode1.add(modLabel);
		mode1.add(mField1);
		mField1.setHorizontalAlignment(JTextField.RIGHT);
		mode1.add(closeBracket);
		
		mode2.setLayout(layout);
		mode2.add(leftBracket);
		mode2.add(aField2);
		mode2.add(xBracket);
		mode2.add(cField2);
		mode2.add(ZSet);
		mode2.add(mField2);
		

		switchPanel.setLayout(card);
		switchPanel.add(mode1, "Mode 1");
		switchPanel.add(mode2, "Mode 2");
		
		
		solvePanel.add(solveButton);
		solveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (currentMode == 0 ) {
					int a = Integer.parseInt(aField1.getText());
					int c = Integer.parseInt(cField1.getText());
					int m = Integer.parseInt(mField1.getText());
					String result = LinearCongruenceSolver.solveCongruence(a, c, m);
					JOptionPane.showMessageDialog(LinearCongruenceSolverGUI.this, result, "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					int a = Integer.parseInt(aField2.getText());
					int c = Integer.parseInt(cField2.getText());
					int m = Integer.parseInt(mField2.getText());
					String result = LinearCongruenceSolver.solveCongruence(a, c, m);
					JOptionPane.showMessageDialog(LinearCongruenceSolverGUI.this, result, "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
	}
}
