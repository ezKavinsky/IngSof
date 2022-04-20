import TextDocExample.src.is.textdoc.builder.DocumentBuilder;
import TextDocExample.src.is.textdoc.latex.LaTeXTextBuilder;
import TextDocExample.src.is.textdoc.parser.TextDocumetParser;

import java.io.File;
import java.io.PrintWriter;

public class LaTeXTest {

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("No input file name given!");
			System.exit(1);
		}
		PrintWriter pw = new PrintWriter(System.out);
		DocumentBuilder builder = new LaTeXTextBuilder(pw);
		// DocumentBuilder builder = new HTMLTextBuilder(pw);
		// DocumentBuilder builder = new JsonTextBuilder(pw);

		TextDocumetParser tp = new TextDocumetParser(builder, new File(args[0]).toURI().toURL().toString());
		tp.build();

	}
}
