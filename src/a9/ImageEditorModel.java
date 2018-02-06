package a9;

import java.util.ArrayList;
import java.util.List;

public class ImageEditorModel {

	private Picture original;
	private ObservablePicture current;
	public static List<Picture> list = new ArrayList<Picture>();

	public ImageEditorModel(Picture f) {
		original = f;
		current = original.copy().createObservable();
	}

	public ObservablePicture getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size) {
		current.suspendObservable();
		;

		for (int xpos = x - brush_size + 1; xpos <= x + brush_size - 1; xpos++) {
			for (int ypos = y - brush_size + 1; ypos <= y + brush_size - 1; ypos++) {
				if (xpos >= 0 && xpos < current.getWidth() && ypos >= 0 && ypos < current.getHeight()) {
					current.setPixel(xpos, ypos, brushColor);
				}
			}
		}
		current.resumeObservable();
	}

	public void undo() {
		//this sets the current picture to the last picture
		//then removes the last picture from the list
		current.suspendObservable();

		if (list.size() > 0) {
			for (int i = 0; i < current.getWidth(); i++) {
				for (int j = 0; j < current.getHeight(); j++) {
					current.setPixel(i, j, list.get(list.size() - 1).getPixel(i, j));
				}
			}
			list.remove(list.size() - 1);
		}
		current.resumeObservable();
	}
}
