package TextDocExample.src.is.textdoc.parser;

import TextDocExample.src.is.textdoc.builder.DocumentBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class TextDocumetParser {

	private String urlstring;

	private BufferedReader br;

	private StringTokenizer st;
	private int lineNr = 0;

	private DocumentBuilder builder;

	private String token;

	public TextDocumetParser(DocumentBuilder builder, String urlstring) {
		this.builder = builder;
		this.urlstring = urlstring;
	}

	public void build() {

		try {
			doParse();
		} catch (TextParseException e) {

			e.printStackTrace();

		}

	}

	private String nextToken() {
		while (st == null || !st.hasMoreTokens()) {

			String line = null;
			try {
				line = br.readLine();
				lineNr++;
			} catch (IOException e) {

				e.printStackTrace();
			}

			if (line == null)
				return line;

			st = new StringTokenizer(line);
		}
		String t = st.nextToken();

		return t;

	}

	private void doParse() throws TextParseException {

		URL url;
		try {
			url = new URL(urlstring);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e) {
			e.printStackTrace();
			throw new TextParseException("Errore di lettura");

		}
		readDocument();
	}

	private void readDocument() throws TextParseException {
		token = nextToken();
		if (!token.equals("<Document>"))
			new TextParseException("line " + lineNr
					+ " Atteso: <Document> trovato:" + token);

		String tit = readText();
		builder.openDocument(tit);

		/* token = nextToken(); */
		if (token == null)
			throw new TextParseException("Atteso token");
		while (!token.equals("</Document>")) {

			if (!token.equals("<Section>"))
				new TextParseException("line " + lineNr
						+ " Atteso: <Section> trovato:" + token);
			readSection();
			token = nextToken();
		}
		builder.closeDocument();
	}

	private void readSection() throws TextParseException {

		String tit = readText();
		builder.openSection(tit);

		if (token == null)
			throw new TextParseException("Atteso token");
		while (!token.equals("</Section>")) {

			if (token.equals("<SubSection>"))
				readSubsection();
			else if (token.equals("<Paragraph>"))
				readParagraph();
			else
				throw new TextParseException("line " + lineNr
						+ " Atteso: <SubSection> o <Paragraph> trovato:"
						+ token);
			token = nextToken();
		}
		builder.closeSection();
	}

	public String readText() throws TextParseException {
		StringBuilder par = new StringBuilder();
		token = nextToken();
		if (token == null)
			throw new TextParseException("line " + lineNr + " Atteso token");
		while (token.charAt(0) != '<') {

			if (token == null)
				throw new TextParseException("line " + lineNr + " Atteso token");
			par.append(" ").append(token);
			//par += " " + token;
			token = nextToken();
		}
		return par.toString();
	}

	private void readParagraph() throws TextParseException {
		StringBuilder par = new StringBuilder();
		token = nextToken();

		while (!token.equals("</Paragraph>")) {

			if (token == null)
				throw new TextParseException("line " + lineNr + " Atteso token");
			par.append(" ").append(token);
			token = nextToken();
		}

		builder.addParagraph(par.toString());
	}

	private void readSubsection() throws TextParseException {
		String tit = readText();
		builder.openSubsection(tit);

		if (token == null)
			throw new TextParseException("line " + lineNr + " Atteso token");
		while (!token.equals("</SubSection>")) {

			if (token.equals("<Paragraph>"))
				readParagraph();
			else
				throw new TextParseException("line " + lineNr
						+ " Atteso: <Paragraph> trovato:" + token);
			token = nextToken();
		}
		builder.closeSubsection();
	}

}