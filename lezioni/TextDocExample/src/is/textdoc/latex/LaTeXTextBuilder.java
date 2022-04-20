package TextDocExample.src.is.textdoc.latex;

import TextDocExample.src.is.textdoc.builder.DocumentBuilder;

import java.io.PrintWriter;

public class LaTeXTextBuilder implements DocumentBuilder {

	private PrintWriter pw;

	public LaTeXTextBuilder(PrintWriter pw) {
		this.pw = pw;
	}

	@Override
	public void openDocument(String title) {
		pw.println("\\documentclass{article}");

		pw.print("\\title{");
		pw.print(title);
		pw.println("}");
		pw.println("\\date{}");
		pw.println("\\author{}");
		pw.println("\\begin{document}");
		pw.println("\\maketitle");

	}

	@Override
	public void closeDocument() {
		pw.println("\\end{document}");

		pw.flush();
	}

	@Override
	public void openSection(String title) {
		pw.print("\\section{");
		pw.print(title);
		pw.println("}");

	}

	@Override
	public void closeSection() {

	}

	@Override
	public void openSubsection(String title) {
		pw.print("\\subsection{");
		pw.print(title);
		pw.println("}");

	}

	@Override
	public void closeSubsection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addParagraph(String text) {
		pw.println(text + "\n");

	}
}
