package ObserverCommandFlyweigth.src.is.shapes.view;

import ObserverCommandFlyweigth.src.is.shapes.model.GraphicObject;

import java.awt.*;

public interface GraphicObjectView {
	void drawGraphicObject(GraphicObject go, Graphics2D g);
}
