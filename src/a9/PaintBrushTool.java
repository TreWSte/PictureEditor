package a9;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PaintBrushTool implements Tool {

	private PaintBrushToolUI ui;
	private ImageEditorModel model;
	
	public PaintBrushToolUI getPaintUI() {
		return ui;
	}
	
	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//every time something is edited, add it to the list
		ImageEditorModel.list.add(ImageEditor.controller.getImageEditorModel().getCurrent().copy());
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), ui.getSizeValue());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//every time something is edited, add it to the list
		ImageEditorModel.list.add(ImageEditor.controller.getImageEditorModel().getCurrent().copy());
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), ui.getSizeValue());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
