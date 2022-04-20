package TextDocExample.src.is.textdoc;

import TextDocExample.src.is.textdoc.visitor.TextDocumentVisitor;

public interface DocumentElement {
	String getText();

	default CompositeDocumentElement asComposite() {
		return null;
	}

	CompositeDocumentElement getParent();

	void accept(TextDocumentVisitor visitor);
}
