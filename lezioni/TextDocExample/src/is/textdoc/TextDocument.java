package TextDocExample.src.is.textdoc;

import TextDocExample.src.is.textdoc.visitor.TextDocumentVisitor;

public class TextDocument extends AbstractCompositeDocumentElement {
	private String title;
	
	@Override
	public String getText() {

		return getTitle();
	}
	@Override
	public void addChild(DocumentElement el) {
		if (!(el instanceof Section))
			throw new IllegalArgumentException();
		super.addChild(el);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String string) {
		title = string;

	}
	
	@Override
	public void accept(TextDocumentVisitor visitor) {
		visitor.visit(this);

	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see is.textdoc.AbstractDocumentElement#setParent(is.textdoc.
	 * CompositeDocumentElement)
	 */
	@Override
	protected void setParent(CompositeDocumentElement parent) {
		throw new UnsupportedOperationException();
	}
}
