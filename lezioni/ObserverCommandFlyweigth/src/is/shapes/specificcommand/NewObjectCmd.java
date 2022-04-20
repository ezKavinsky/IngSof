package ObserverCommandFlyweigth.src.is.shapes.specificcommand;

import ObserverCommandFlyweigth.src.is.command.Command;
import ObserverCommandFlyweigth.src.is.shapes.model.GraphicObject;
import ObserverCommandFlyweigth.src.is.shapes.view.GraphicObjectPanel;

public class NewObjectCmd implements Command {

	private GraphicObjectPanel panel;
	private GraphicObject go;

	public NewObjectCmd(GraphicObjectPanel panel, GraphicObject go) {
		
		this.panel = panel;
		this.go = go;
		
	}

	@Override
	public boolean doIt() {
		double x = 10;
		double y =  10;
		go.moveTo(x, y);
		panel.add(go);

		return true;
	}

	@Override
	public boolean undoIt() {
		panel.remove(go);
		return true;
	}

}
