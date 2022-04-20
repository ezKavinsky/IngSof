package TextDocExample.src.is.textdoc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractCompositeDocumentElement extends
		AbstractDocumentElement implements CompositeDocumentElement {

	private ArrayList<DocumentElement> elements = new ArrayList<>();

	@Override
	public DocumentElement getChild(int i) {
		return elements.get(i);
	}

	@Override
	public void addChild(DocumentElement el) {
		elements.add(el);
		((AbstractDocumentElement) el).setParent(this);
	}
	
	@Override
	public void removeChild(int i) {
		AbstractDocumentElement el = (AbstractDocumentElement) elements
				.remove(i);
		el.setParent(null);

	}
	@Override
	public int getChildrenCount() {
		return elements.size();
	}

	@Override 
	public final CompositeDocumentElement asComposite() {
		return this;
	}
	
	@Override
	public Iterator<DocumentElement> iterator() {
		return new InnerIteartor();
	}

	private class InnerIteartor implements Iterator<DocumentElement> {
		Iterator<DocumentElement> it = elements.iterator();
		private AbstractDocumentElement last = null;

		@Override
		public void remove() {
			if (last == null)
				throw new NoSuchElementException();
			// throw new UnsupportedOperationException();
			it.remove();
			last.setParent(null);
			last = null;
		}

		@Override
		public boolean hasNext() {

			return it.hasNext();
		}

		@Override
		public DocumentElement next() {
			last = (AbstractDocumentElement) it.next();
			return last;
		}

	}
	
}
