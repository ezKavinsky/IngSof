package TextDocExample.src.is.textdoc.visitor;

import TextDocExample.src.is.textdoc.Paragraph;
import TextDocExample.src.is.textdoc.Section;
import TextDocExample.src.is.textdoc.SubSection;
import TextDocExample.src.is.textdoc.TextDocument;

public interface TextDocumentVisitor {
	void visit(TextDocument d);

	void visit(Section s);

	void visit(SubSection sub);

	void visit(Paragraph p);
}
