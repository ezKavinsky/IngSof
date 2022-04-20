package TextDocExample.src.is.textdoc.txt;

import TextDocExample.src.is.textdoc.*;
import TextDocExample.src.is.textdoc.visitor.TextDocumentVisitor;

import java.io.PrintStream;
import java.io.PrintWriter;

public class PlainTextVisitor implements TextDocumentVisitor {

	private PrintWriter pw;

	public PlainTextVisitor(PrintWriter pw) {
		this.pw = pw;
	}

	public PlainTextVisitor(PrintStream ps) {
		pw = new PrintWriter(ps);
	}

	@Override
	public void visit(TextDocument doc) {
		pw.println("Title: " + doc.getTitle());
		for (DocumentElement de : doc)
			de.accept(this);
		pw.flush();
	}

	@Override
	public void visit(Section sec) {
		pw.println("Section: " + sec.getTitle());
		for (DocumentElement de : sec)
			de.accept(this);

	}

	@Override
	public void visit(SubSection sub) {
		pw.println("Subsection: " + sub.getTitle());
		for (DocumentElement de : sub)
			de.accept(this);

	}

	@Override
	public void visit(Paragraph p) {
		pw.println(p.getText());

	}

}
