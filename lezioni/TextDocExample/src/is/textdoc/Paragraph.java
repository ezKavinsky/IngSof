package TextDocExample.src.is.textdoc;

import TextDocExample.src.is.textdoc.visitor.TextDocumentVisitor;

public class Paragraph extends AbstractDocumentElement {
	private String text;

	public Paragraph() {
		this("");
	}

	public Paragraph(String text) {
		this.text = text;
	}

	@Override
	public String getText() {

		return text;
	}

	@Override
	protected void setParent(CompositeDocumentElement p) {
		if (p != null && !(p instanceof Section || p instanceof SubSection))
			throw new IllegalArgumentException();
		super.setParent(p);
	}

	public void setText(String string) {
		text = string;
	}

	@Override
	public void accept(TextDocumentVisitor visitor) {
		visitor.visit(this);
	}

}
