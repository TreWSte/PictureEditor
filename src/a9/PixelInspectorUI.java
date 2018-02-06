package a9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PixelInspectorUI extends JPanel implements ActionListener {

	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton copy_button;
	private int red;
	private int blue;
	private int green;
	
	
	public PixelInspectorUI() {
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		copy_button = new JButton("Copy Pixel");
	
		copy_button.addActionListener(this);

		setLayout(new GridLayout(5,1));
		add(x_label);
		add(y_label);
		add(pixel_info);
		add(copy_button);
	}
	
	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));
		double intermediate;
		intermediate = p.getRed() * 100;
		red = (int) intermediate;
		intermediate = p.getBlue() * 100;
		blue = (int) intermediate;
		intermediate = p.getGreen() * 100;
		green = (int) intermediate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//set the values in the paintUI to the values from the pixel
		ImageEditor.controller.getPaintBrushtool().getPaintUI().setRed(red);
		ImageEditor.controller.getPaintBrushtool().getPaintUI().setBlue(blue);
		ImageEditor.controller.getPaintBrushtool().getPaintUI().setGreen(green);
	}
	


}
