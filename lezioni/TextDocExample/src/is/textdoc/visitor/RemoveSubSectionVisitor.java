package TextDocExample.src.is.textdoc.visitor;

import TextDocExample.src.is.textdoc.*;

import java.util.Iterator;
import java.util.LinkedList;

public class RemoveSubSectionVisitor implements TextDocumentVisitor {
	private LinkedList<DocumentElement> list = new LinkedList<>();

	@Override
	public void visit(TextDocument d) {

		for (DocumentElement de : d) {
			de.accept(this);
		}
	}

	@Override
	public void visit(Section s) {
		assert list.isEmpty();
		// svuota la sezione corrente
		Iterator<DocumentElement> it = s.iterator();
		while (it.hasNext()) {
			DocumentElement de = it.next();
			de.accept(this);
			it.remove();
		}
		// ripopola la sezione
		it = list.iterator();
		while (it.hasNext()) {
			s.addChild(it.next());
			it.remove();
		}
		assert list.isEmpty();

	}

	@Override
	public void visit(SubSection sub) {
		list.add(new Paragraph("--"+sub.getText()+" --\n"));
		for (DocumentElement de : sub) {
			de.accept(this);
		}
	}

	@Override
	public void visit(Paragraph p) {
		list.add(p);
	}

}
