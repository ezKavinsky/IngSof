package TextDocExample.src.is.textdoc.builder;

import TextDocExample.src.is.textdoc.*;

public class TextDocumentBuilder implements DocumentBuilder {
	private CompositeDocumentElement curr;

	private TextDocument doc;

	private boolean ready = false;

	public TextDocument getDocument() {
		if (!ready)
			throw new IllegalStateException();
		ready = false;
		return doc;

	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#openDocument(java.lang.String)
	 */
	@Override
	public void openDocument(String title) {
		ready = false;
		TextDocument document = new TextDocument();
		document.setTitle(title);
		curr = document;
	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#closeDocument()
	 */
	@Override
	public void closeDocument() {
		ready = true;
		doc = (TextDocument) curr;
	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#openSection(java.lang.String)
	 */
	@Override
	public void openSection(String title) {

		Section section = new Section(title);
		curr.addChild(section);
		curr = section;
	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#addParagraph(java.lang.String)
	 */
	@Override
	public void addParagraph(String text) {
		Paragraph p = new Paragraph(text);
		curr.addChild(p);

	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#closeSection()
	 */
	@Override
	public void closeSection() {

		curr = curr.getParent();
	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#openSubsection(java.lang.String)
	 */
	@Override
	public void openSubsection(String title) {

		SubSection subsection = new SubSection(title);
		curr.addChild(subsection);
		curr = subsection;
	}

	/* (non-Javadoc)
	 * @see is.textdoc.DocumentBuilder#closeSubSection()
	 */
	@Override
	public void closeSubsection() {

		curr = curr.getParent();
	}
}