package TextDocExample.src.is.textdoc.html;

import TextDocExample.src.is.textdoc.builder.DocumentBuilder;

import java.io.PrintWriter;

public class HTMLTextBuilder implements DocumentBuilder {
	private PrintWriter pw;

	public HTMLTextBuilder(PrintWriter pw) {
		this.pw = pw;
	}

	@Override
	public void openDocument(String title) {
		pw.println("<html><body>");
		pw.println("<h1>" + title + "</h1>");

	}

	@Override
	public void closeDocument() {
		pw.println("</body></html>");
		pw.flush();

	}

	@Override
	public void openSection(String title) {
		pw.println("<h2>" + title + "</h2>");

	}

	@Override
	public void closeSection() {

	}

	@Override
	public void openSubsection(String title) {
		pw.println("<h3>" + title + "</h3>");
	}

	@Override
	public void closeSubsection() {

	}

	@Override
	public void addParagraph(String text) {
		pw.println(text + "<br/>");

	}

}
