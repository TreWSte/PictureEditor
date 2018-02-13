package a9;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditor {
	public static ImageEditorController controller;
	public static void main(String[] args) throws IOException {
		//this gets the picture from this url
		Picture f = PictureImpl.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");

		//this sets up the main outside frame
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 9 Image Editor");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//this puts the picture in the frame
		ImageEditorModel model = new ImageEditorModel(f);
		ImageEditorView view = new ImageEditorView(main_frame, model);
 		controller = new ImageEditorController(view, model);
		
		//this puts a panel in the frame for the user to interact with
		//this is how the user edits the picture
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(view, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		//finally, pack the frame and let it be visible
		main_frame.pack();
		main_frame.setVisible(true);
	}
}
