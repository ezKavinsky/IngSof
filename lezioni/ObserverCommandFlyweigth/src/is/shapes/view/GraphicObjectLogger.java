package ObserverCommandFlyweigth.src.is.shapes.view;

import ObserverCommandFlyweigth.src.is.shapes.model.GraphicEvent;
import ObserverCommandFlyweigth.src.is.shapes.model.GraphicObject;
import ObserverCommandFlyweigth.src.is.shapes.model.GraphicObjectListener;

public class GraphicObjectLogger implements GraphicObjectListener {

	public void graphicChanged(GraphicEvent e) {
		GraphicObject go = e.getSource();
		System.out.printf("[%s] pos=[%f,%f] dim=[%f,%f]%n", go.getType(), go
				.getPosition().getX(), go.getPosition().getY(), go
				.getDimension().getWidth(),
				go.getDimension().getHeight());
	}

}
